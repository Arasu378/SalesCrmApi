package consumeclass;

import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import model.OrganizationModel;
import response.OrganizationResponse;
import utils.Constants;

public class UpdateOragnizationClass {
public static OrganizationResponse updateOrganization(OrganizationModel model){
	OrganizationResponse response=new OrganizationResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="{Call `Company.Organization_UpdateOrganization`(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		
		String name=model.getName();
		callableStatement.setString(1, name);
		int peopleCount=model.getPeopleCount();
		callableStatement.setInt(2, peopleCount);
		int userProfileId=model.getOwnersUserProfileId();
		String address=model.getAddress();
		callableStatement.setString(3, address);
		String cCEmail=model.getCCEmail();
		callableStatement.setString(4, cCEmail);
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 Date date = new Date();
		 System.out.println(dateFormat.format(date));
		String  modifiedDate=dateFormat.format(date);
		callableStatement.setString(5, modifiedDate);
		int openDealsCount=model.getOpenDealsCount();
		callableStatement.setInt(6,openDealsCount);
		int relatedOpenDealsCount=model.getRelatedOpenDealsCount();
		callableStatement.setInt(7,relatedOpenDealsCount);

		int closedDealsCount=model.getClosedDealsCount();
		callableStatement.setInt(8,closedDealsCount);

		int relatedClosedDealsCount=model.getRelatedClosedDealsCount();
		callableStatement.setInt(9,relatedClosedDealsCount);

		int emailMessagesCount=model.getEmailMessagesCount();
		callableStatement.setInt(10,emailMessagesCount);

		int activitiesCount=model.getActivitiesCount();
		callableStatement.setInt(11,activitiesCount);

		int doneActivitiesCount=model.getDoneActivitiesCount();
		callableStatement.setInt(12,doneActivitiesCount);

		int undoneActivitesCount=model.getUndoneActivitiesCount();
		callableStatement.setInt(13,undoneActivitesCount);

		int referenceActivitiesCount=model.getReferenceActivitiesCount();
		
		callableStatement.setInt(14,referenceActivitiesCount);

		int filesCount=model.getFilesCount();
		callableStatement.setInt(15,filesCount);

		int notesCount=model.getNotesCount();
		callableStatement.setInt(16,notesCount);

		int followersCount=model.getFollowersCount();
		callableStatement.setInt(17,followersCount);

		int wonDealsCount=model.getWonDealsCount();
		callableStatement.setInt(18,wonDealsCount);

		int relatedWonDealsCount=model.getRelatedwonDealsCount();
		callableStatement.setInt(19,relatedWonDealsCount);

		int lostDealsCount=model.getLostDealsCount();
		callableStatement.setInt(20,lostDealsCount);

		int relatedLostDealsCount=model.getRelatedLostDealsCount();
		callableStatement.setInt(21,relatedLostDealsCount);

		boolean activeFlag=model.getActiveFlag();
		callableStatement.setBoolean(22,activeFlag);

		int categoryId=model.getCategoryId();
		callableStatement.setInt(23,categoryId);

		int pictureId=model.getPictureId();
		callableStatement.setInt(24,pictureId);

		String countryCode=model.getCountryCode();
		callableStatement.setString(25,countryCode);

		String firstChar=model.getFirstChar();
		callableStatement.setString(26,firstChar);

		int visibleTo=model.getVisibleTo();
		callableStatement.setInt(27,visibleTo);

		String nextActivityDate=model.getNextActivityDate();
		callableStatement.setString(28,nextActivityDate);

		String nextActivityTime=model.getNextActivityTime();
		callableStatement.setString(29,nextActivityTime);

		int nextActivityId=model.getNextActivityId();
		callableStatement.setInt(30,nextActivityId);

		int lastActivityId=model.getLastActivityId();
		callableStatement.setInt(31,lastActivityId);

		String lastActivityDate=model.getLastActivityDate();
		callableStatement.setString(32,lastActivityDate);

		String timeLineLastActivityTime=model.getTimeLineLastActivityTime();
		callableStatement.setString(33,timeLineLastActivityTime);

		String timeLineLastActivityTimeByOwner=model.getTimeLineLastActivityTimeByOwner();
		callableStatement.setString(34,timeLineLastActivityTimeByOwner);

		String addressSubpremise=model.getAddressSubpremise();
		callableStatement.setString(35,addressSubpremise);

		String addressStreetNumber=model.getAddressStreetNumber();
		callableStatement.setString(36,addressStreetNumber);

		String addressRoute=model.getAddressRoute();
		callableStatement.setString(37,addressRoute);

		String addressSubLocality=model.getAddressSubLocality();
		callableStatement.setString(38,addressSubLocality);

		String addressLocality=model.getAddressLocality();
		callableStatement.setString(39,addressLocality);

		String addressAdminAreaLevel1=model.getAddressAdminAreaLevel1();
		callableStatement.setString(40,addressAdminAreaLevel1);

		String addressAdminAreaLevel2=model.getAddressAdminAreaLevel2();
		callableStatement.setString(41,addressAdminAreaLevel2);

		String addressCountry=model.getAddressCountry();
		callableStatement.setString(42,addressCountry);

		String addressPostalCode=model.getAddressPostalCode();
		callableStatement.setString(43,addressPostalCode);

		String addressFormattedAddress=model.getAddressFormattedAddress();
		callableStatement.setString(44,addressFormattedAddress);

		String ownerName=model.getOwnerName();
		callableStatement.setString(45,ownerName);

		int organizationId=model.getOrganizationId();
		callableStatement.setInt(46,organizationId);

		
		
		
		
		
		
		int count = callableStatement.executeUpdate();
		if(count>0){
			response=GetOrganizationByUserProfileIdClass.getOrganizationByUserProfileId(userProfileId);
		}else{
			response.setIsSuccess(false);
			response.setMessage("Organization  is not inserted");
			response.setOrganizationList(null);
		}	
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(connection!=null){
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		if(callableStatement!=null){
			try {
				callableStatement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	return response;
}
}
