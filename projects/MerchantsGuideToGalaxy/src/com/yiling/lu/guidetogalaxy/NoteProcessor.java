package com.yiling.lu.guidetogalaxy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;

import com.yiling.lu.romannumerals.RomanNumeral;
import com.yiling.lu.romannumerals.exception.RomanNumberalException;
import com.yiling.lu.romannumerals.exception.SymbolAlreadyDefinedException;
import com.yiling.lu.romannumerals.exception.UndefinedExternalSymbolException;
import com.yiling.lu.romannumerals.utils.RomanNumeralUtil;
import com.yiling.lu.romannumerals.utils.StringEncodingUtil;

/**
 * @author yiling.lu@outlook.com
 *
 */
public class NoteProcessor {
	NumeralTranslationTable table = NumeralTranslationTable.getInstance();
	
	private static String howMuchLine = "how much is";
	private static String credits = "Credits";
	private static String isString = "is";
	private static String how = "how";
	private static String much = "much";
	private static String many = "many";
	
	/**
	 * Define these as reserved words to avoid confusion in the note.
	 */
	private static String[] reservedWords = {"credit"};
	
	private static String qMark = "?";
	
	private HashMap<String,Boolean> keyOrReservedWords = new HashMap<String,Boolean>();
	
	private HashMap<String,Boolean> variableNamespace = new HashMap<String,Boolean>();
	
	private HashMap<String,CreditData> metalCreditTable = new HashMap<String,CreditData>();
	
	/**
	 * Line starts with // will be treated as comments.
	 */
	private String commentRegex = "^\\s*//.*$";
	
	/**
	 * <p>
	 * allow white space at begining and end of line
	 * </p>
	 * The followings are valid lines:<p/>
	 * <ul>
	 * <li>
	 * glob is X
	 * </li>
	 * <li>
	 *  &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;glob is X
	 *  </li>
	 *  <li>
	 *  glob &nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;is&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;x
	 * </li>
	 * </ul>
	 */
	private String defLineRegex = "^\\s*[\\w-]{1,}?\\s*is\\s*[IVXLCDM]\\s*$";
	
	/**
	 * Match line starting with "how much is", end with "?".
	 * Extra space in between is allowed.
	 * 
	 * e.g. "how much is pish tegj glob glob ?" is a match. "how much isglob?" is not a match.
	 */
	private String howmuchQueryRegex = "^\\s*how\\s{1,}?much\\s{1,}?is\\s{1,}?\\w{1,}?.*[?]\\s*$";
	
	/**
	 * glob glob Silver is 34 Credits
	 * gob Silver is 80 Credits
	 * <br/>
	 * 
	 * Both "credits" and "Credits" are allowed.
	 */
	private String creditDefRegex = "^\\s*\\w{1,}?.*\\s{1,}?is\\s{1,}?\\d{1,}?\\s{1,}?[Cc]redits\\s*$";
	
	/**
	 * <p>
	 * This regex is to match this query: <br/>
	 * how many Credits is glob prok Silver ?
	 * </p>
	 */
	private String howmanyCreditQueryRegex = "^\\s*how\\s{1,}?many\\s{1,}?[Cc]redits\\s{1,}?is\\s{1,}?\\w{1,}?.*[?]\\s*$";
	
	
	public NoteProcessor(){
		keyOrReservedWords.put(credits.toUpperCase(), Boolean.TRUE);
		keyOrReservedWords.put(isString.toUpperCase(), Boolean.TRUE);
		keyOrReservedWords.put(how.toUpperCase(), Boolean.TRUE);
		keyOrReservedWords.put(much.toUpperCase(), Boolean.TRUE);
		keyOrReservedWords.put(many.toUpperCase(), Boolean.TRUE);
		
		keyOrReservedWords.put(new Character(RomanNumeral.I.charValue()).toString(), Boolean.TRUE);
		keyOrReservedWords.put(new Character(RomanNumeral.V.charValue()).toString(), Boolean.TRUE);
		keyOrReservedWords.put(new Character(RomanNumeral.X.charValue()).toString(), Boolean.TRUE);
		keyOrReservedWords.put(new Character(RomanNumeral.L.charValue()).toString(), Boolean.TRUE);
		keyOrReservedWords.put(new Character(RomanNumeral.C.charValue()).toString(), Boolean.TRUE);
		keyOrReservedWords.put(new Character(RomanNumeral.D.charValue()).toString(), Boolean.TRUE);
		keyOrReservedWords.put(new Character(RomanNumeral.M.charValue()).toString(), Boolean.TRUE);	
		
		for(int i=0; i<reservedWords.length; i++){
			keyOrReservedWords.put(reservedWords[i].toUpperCase(), Boolean.TRUE);
		}
		
	}
	
	public void processLine(String line) throws SymbolAlreadyDefinedException, 
			UndefinedExternalSymbolException {
		try {
			if (!line.matches(commentRegex)) { // skip comment lines

				if(line.matches(defLineRegex)) {

					parseVariableDefLine(line);

				}else if (line.matches(howmuchQueryRegex)) {

					parseNumberQueryLine(line);

				}else if (line.matches(creditDefRegex)) {
					
					parseCreditDefinitionLine(line);
				}else if(line.matches(howmanyCreditQueryRegex)){
					
					parseCreditsQueryLine(line);
				}else{
					noKnowledgeLine(line);
				}
			}
		} catch (RomanNumberalException ex) {
			
			System.out.print("Error in processing line: " + StringEncodingUtil.quotes(line) + ". ");
			String msg = ex.getMessage();
			System.out.println(symbolSubstitution(msg));
			
		} catch(RuntimeException ex){
			
			System.out.print("Error in processing line:" + StringEncodingUtil.quotes(line) + ". ");
			System.out.println(ex.getMessage());
//			ex.printStackTrace();
		}
	}
	
	/**
	 * Process credit defintion line, e.g. "gob nob Silver is 80 Credits"
	 * 
	 * @param creditDefLine
	 * @throws UndefinedExternalSymbolException 
	 */
	private void parseCreditDefinitionLine(String creditDefLine) throws UndefinedExternalSymbolException{
		creditDefLine = creditDefLine.trim();
		int begin = creditDefLine.lastIndexOf(isString);
		// index of the empty space just before the word Credits/credits
		int end = creditDefLine.lastIndexOf(" ");
		
		String creditPointsTxt = creditDefLine.substring(begin+isString.length(), end+1).trim();
		int creditPoint = Integer.parseInt(creditPointsTxt.trim());
		
		// this substring is "gob nob Silver"
		String numberLine = creditDefLine.substring(0,begin);
		ArrayList<String> list = parseToList(numberLine);
		
		CreditData creditData = new CreditData();
		String metalName = list.get(list.size()-1);
		checkVariableNamespace(metalName);

		creditData.setMetal(metalName);
		creditData.setCreditPoint(creditPoint);
		
		if(list.size()>1){
			int base = computeIntValue(list.subList(0, list.size()-1));
			creditData.setBase(base);
		}		
		
		checkMetalCreditTable(metalName);
		
		metalCreditTable.put(metalName, creditData);
	}
	
	/**
	 * how many Credits is glob prok Silver ?
	 * 
	 * @param creditQLine Credits query in the form of "how many Credits is glob prok Silver ?"
	 */
	private void parseCreditsQueryLine(String creditQLine){
		creditQLine = creditQLine.trim();
		int begin = creditQLine.indexOf(isString);
		int end = creditQLine.indexOf(qMark);
		
		String queryTxt = creditQLine.substring(begin+isString.length(),end).trim();
		
		ArrayList<String> numberList = parseToList(queryTxt);
		String metal = numberList.get(numberList.size()-1);
		
		int amount = computeIntValue(numberList.subList(0, numberList.size()-1));
		
		CreditData creditData = metalCreditTable.get(metal);
		
		if(creditData == null){
			throw new RuntimeException(buildCreditDataErrorMessage(metal));
		}else{
			
			int roundUp = CreditCalcUtil.calcCreditPoints(creditData, amount);
			
			System.out.println(buildCreditQueryOutput(queryTxt, roundUp));
		}
	}
	
	/**
	 * Parse this line "how much is pish tegj glob glob ?" to ouput integer value
	 * to answer this question.
	 * 
	 * @param line e.g. "how much is pish tegj glob glob ?"
	 * @throws UndefinedExternalSymbolException
	 */
	private void parseNumberQueryLine(String line) throws UndefinedExternalSymbolException{
		line = line.trim();
		int begin = line.indexOf(howMuchLine);
		int end = line.indexOf(qMark);
		
		String numberTxt = line.substring(begin+howMuchLine.length(), end).trim();
		
		int num = tokenizeNCalcInt(numberTxt);
		System.out.println(howMuchLineResult(numberTxt, num));
	}
	
	private int tokenizeNCalcInt(String line) throws UndefinedExternalSymbolException{
		return computeIntValue(parseToList(line));
	}
	
	private ArrayList<String> parseToList(String line){
		StringTokenizer tk = new StringTokenizer(line);
		ArrayList<String> list = new ArrayList<String>();
		
		while(tk.hasMoreElements()){
			String s = tk.nextElement().toString();
			list.add(s);
		}
		
		return list;
		
	}
	
	private int computeIntValue(Collection<String> variables){
		Iterator<String> it = variables.iterator();
		
		StringBuilder romanNumeralString = new StringBuilder();
		while(it.hasNext()){
			String symbol = it.next();
			
			RomanNumeral r = table.getRomanNumeral(symbol);
			
			if(r==null){
				throw new UndefinedExternalSymbolException(buildNotDefinedSymbolMessage(symbol));
			}else{
				romanNumeralString.append(r.charValue());
			}
		}
		
		int num = RomanNumeralUtil.convertRomanToInt(romanNumeralString.toString());
		return num;
	}
	
	private void parseVariableDefLine(String line) throws SymbolAlreadyDefinedException{
		line = line.trim();
		char ch = line.charAt(line.length()-1);
		
		//String between beginning of the line to the first space is the 
		//variable name
		int index = line.indexOf(" ");
		String variableName = line.substring(0, index);
		checkKeyword(variableName);
		
		// check if there is an existing mapping between a Roman numeral of the same
		// character and a variable of the same name.
		RomanNumeral mappedRomanNumeral = table.getRomanNumeral(variableName);
		String mappedVariable = table.getSymbol(ch);
		
		if(mappedVariable != null){
			throw new SymbolAlreadyDefinedException(buildSymbolDefinedErrorMessage(new String(new char[]{ch}),mappedVariable));
		}
				
		if(mappedRomanNumeral != null){
			throw new SymbolAlreadyDefinedException(buildSymbolDefinedErrorMessage(variableName, new String(new char[]{mappedRomanNumeral.charValue()})));
		}
		
		table.addSymbol(variableName, RomanNumeralUtil.lookUpRomanNumeral(ch));
		variableNamespace.put(variableName, Boolean.TRUE);
	}
	
	private String buildCreditQueryOutput(String queryTxt, int amount){
		StringBuilder br = new StringBuilder(queryTxt);
		br.append(" is ");
		br.append(amount);
		br.append(" ");
		br.append(credits);
		
		return br.toString();
	}
	
	private String buildCreditDataErrorMessage(String metal){
		StringBuilder br = new StringBuilder("Credit points not defined for ");
		br.append(metal);
		br.append(".");
		
		return br.toString();
	}
	
	private String buildSymbolDefinedErrorMessage(String m, String n){
		StringBuilder br = new StringBuilder();
		br.append(m);
		br.append(" is already mapped to ");
		br.append(n);
		br.append(".");
		
		return br.toString();
	}
	
	private String buildNotDefinedSymbolMessage(String m){
		StringBuilder br = new StringBuilder();
		br.append("\"");
		br.append(m);
		br.append("\"");
		br.append(" is not mapped to a Roman numeral.");
		return br.toString();		
	}
	
	private String howMuchLineResult(String m, int n){
		StringBuilder br = new StringBuilder();
		br.append(m);
		br.append(" is ");
		br.append(n);
		br.append(".");
		
		return br.toString();			
	}
	
	private String buildCreditDefinitionLineOutput(CreditData creditData){
		StringBuilder br = new StringBuilder();
		br.append(creditData.getBase());
		br.append(" ");
		br.append(creditData.getMetal());
		br.append(" is ");
		br.append(creditData.getCreditPoint());
		br.append(" ");
		br.append(credits);
		
		return br.toString();
		
		
	}
	private void checkKeyword(String str){
		if(keyOrReservedWords.get(str.toUpperCase()) != null){
			StringBuilder br = new StringBuilder("Cannot use ");
			br.append("\"");
			br.append(str);
			br.append("\"");
			br.append(", it is a keyword or reserved.");
			throw new RuntimeException(br.toString());
		}
	}
	
	private void checkVariableNamespace(String str){
		if(variableNamespace.get(str) != null){
			throw new RuntimeException(str+ " has already been used as variable name");
		}
	}
	
	private void checkMetalCreditTable(String metal){
		if(metalCreditTable.get(metal) != null){
			StringBuilder br = new StringBuilder("Credit points for ");
			br.append("\"");
			br.append(metal);
			br.append("\"");
			br.append(" has already been defined.");			
			throw new RuntimeException(br.toString());
		}		
	}
	
	private void noKnowledgeLine(String line){
//		System.out.println("I have no idea what you are talking about." + ": " + line);
		System.out.println("I have no idea what you are talking about.");
	}
	
	/**
	 * Substitute string encoded such as {I} or {V} to variable name.
	 * 
	 * @param msg
	 */
	private String symbolSubstitution(String msg){
		NumeralTranslationTable table = NumeralTranslationTable.getInstance();
		RomanNumeral[] rNumerals = table.getAllRomanNumerals();
		HashMap<String,String> encodedMap = NumeralTranslationTable.getInstance()
				.getEncodedMap();
		
		for(int i=0; i<rNumerals.length; i++){
			String r = new Character(rNumerals[i].charValue()).toString();
			String encodedR = StringEncodingUtil.encode(r).trim();
			String userSymbol = encodedMap.get(encodedR);
			
			if(userSymbol!=null){
				if(msg.indexOf(encodedR) != -1){
					msg = msg.replace(encodedR, userSymbol);
				}
			}
			
		}
		return msg;
	}
	
	
}
