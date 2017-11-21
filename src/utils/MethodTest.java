/**
 * 
 */
package utils;

import consumeclass.InsertTokenClass;

/**
 * @author thirunavukkarasu
 *
 */
public class MethodTest {
	private final static String token="'bG9rZXNoYmVicm9rZW5ieUBnbWFpbC5jb218bG9rZXNoMTIzfDEwMDAxNQ=='";
	private static final String token_dummy="'dummy_token'";
	public static void main(String[] args) {
	boolean value=InsertTokenClass.findTokenIfExist(token_dummy);
	System.out.println("Boolean value : "+value);

	}
}
