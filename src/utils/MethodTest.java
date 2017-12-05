/**
 * 
 */
package utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javassist.bytecode.Descriptor.Iterator;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import consumeclass.InsertTokenClass;

/**
 * @author thirunavukkarasu
 *
 */
public class MethodTest {
	private final static String token="100015|bG9rZXNoYmVicm9rZW5ieUBnbWFpbC5jb218bG9rZXNoMTIzfDEwMDAxNQ==";
	private static final String token_dummy="'dummy_token'";
	private static String json="[{\"UserEmail\":\"arasu@gmail.com\",\"Password\":\"YXJhc3UzNzg=\",\"UserProfileId\":100043,\"CompanyId\":0,\"CompanyCode\":\"0c32f6b3-d98a-11e7-9384-1c6f652e6ac6\",\"CompanyName\":\"7895as\",\"ConnectionId\":0,\"IsConnectedToMailChimpAccount\":false,\"EmailIntegrationId\":0,\"IsMyLinkedEmailsShared\":false,\"IsMyEmailConversationsPrivate\":false,\"IsLinkMyEmailManually\":false,\"IsEmailLinkWithDeals\":false,\"ContactId\":0,\"IsConnectedToGoogleAccount\":false,\"DriveId\":0,\"ProfilePictureId\":0,\"AttachmentId\":0,\"ReminderEmailId\":0,\"UserInterfaceId\":0,\"IsDeal\":false,\"IsPerson\":false,\"IsOrganization\":false,\"TimeZone\":\"\",\"UserLocaleId\":0,\"LanguageId\":0,\"CurrencyId\":0,\"IsActive\":true,\"CreatedDate\":\"2017-12-05 12:30:59.0\",\"ModifiedDate\":\"\",\"HasPic\":false,\"RegistrationId\":100051,\"UserName\":\"\",\"IndustryTypeId\":5,\"LastLogin\":\"\",\"Token\":\"YXJhc3VAZ21haWwuY29tfCdZWEpoYzNVek56Zz0nfDEwMDA0Mw==\"}]";
	public static void main(String[] args) {
//	boolean value=InsertTokenClass.findTokenIfExist(token_dummy);
//	System.out.println("Boolean value : "+value);
//		int userProfileId=getUserProfileId(token);
//		System.out.println("UserProfileId : "+userProfileId);
//		String getToken=InsertTokenClass.getTokenByUserProfileId(userProfileId);
//		System.out.println("getToken : "+getToken);
//		if(getToken.equals("bG9rZXNoYmVicm9rZW5ieUBnbWFpbC5jb218bG9rZXNoMTIzfDEwMDAxNQ==")){
//		System.out.println("True");
//		}
//		System.out.println("False");
		testKeyValueJson(json);
		
	

	}
	private static int getUserProfileId(String token){
		StringTokenizer stringTokenizer=new StringTokenizer(token);
		String firstOne=stringTokenizer.nextToken("|");
		System.out.println("First Token : "+firstOne);

		String secondOne=stringTokenizer.nextToken();
		System.out.println("Second Token : "+secondOne);

		return Integer.parseInt(firstOne);
	}
	private static void testKeyValueJson(String json){
		JSONArray o=new JSONArray(json);
		Set<String>value=getAllKeys(o);
		for(String m:value){
			System.out.println("Key : "+m);
		}
		
	}
	public static Set<String> getAllKeys(JSONObject json) {
	    return getAllKeys(json, new HashSet<>());
	}

	public static Set<String> getAllKeys(JSONArray arr) {
	    return getAllKeys(arr, new HashSet<>());
	}

	private static Set<String> getAllKeys(JSONArray arr, Set<String> keys) {
	    for (int i = 0; i < arr.length(); i++) {
	        Object obj = arr.get(i);
	        if (obj instanceof JSONObject) keys.addAll(getAllKeys(arr.getJSONObject(i)));
	        if (obj instanceof JSONArray) keys.addAll(getAllKeys(arr.getJSONArray(i)));
	    }

	    return keys;
	}

	private static Set<String> getAllKeys(JSONObject json, Set<String> keys) {
	    for (String key : json.keySet()) {
	        Object obj = json.get(key);
	        if (obj instanceof JSONObject) keys.addAll(getAllKeys(json.getJSONObject(key)));
	        if (obj instanceof JSONArray) keys.addAll(getAllKeys(json.getJSONArray(key)));
	    }

	    keys.addAll(json.keySet());
	    return keys;
	}
}
