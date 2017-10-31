package consumeclass;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import model.PersonModel;
import response.PersonResponse;
import utils.Constants;

public class UpdatePersonClass {
public static PersonResponse updatePerson(PersonModel model){
	PersonResponse response=new PersonResponse();
	Connection connection=null;
	CallableStatement callableStatement=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}
	try{
		String query="{CALL `UserSettings.Person_UpdatePerson`(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		callableStatement=connection.prepareCall(query);
		int userProfileId=model.getUserProfileId();
		String userName=model.getUserName();
		callableStatement.setString(1, userName);
		String modifiedDate=model.getModifiedDate();
		callableStatement.setString(2, modifiedDate);

		String companyCode=model.getCompanyCode();
		callableStatement.setString(3, companyCode);

		int orgId=model.getOrgId();
		callableStatement.setInt(4, orgId);

		String name=model.getName();
		callableStatement.setString(5, name);

		String firstName=model.getFirstName();
		callableStatement.setString(6, firstName);

		String lastName=model.getLastName();
		callableStatement.setString(7, lastName);

		int openDealsCount=model.getOpenDealsCount();
		callableStatement.setInt(8, openDealsCount);

		int relatedOpenDealsCount=model.getRelatedOpenDealsCount();
		callableStatement.setInt(9, relatedOpenDealsCount);

		int participantOpenDealsCount=model.getParticipantOpenDealsCount();
		callableStatement.setInt(10, participantOpenDealsCount);

		int participantClosedDealsCount=model.getParticipantsClosedDealsCount();
		callableStatement.setInt(11, participantClosedDealsCount);

		int emailMessagesCount=model.getEmailMessagesCount();
		callableStatement.setInt(12, emailMessagesCount);

		int activitiesCount=model.getActivitiesCount();
		callableStatement.setInt(13, activitiesCount);

		int doneActivitiesCount=model.getDoneActivitiesCount();
		callableStatement.setInt(14, doneActivitiesCount);

		int undoneActivitiesCount=model.getUndoneActivitiesCount();
		callableStatement.setInt(15, undoneActivitiesCount);

		int referenceActivitiesCount=model.getReferenceActivitiesCount();
		callableStatement.setInt(16, referenceActivitiesCount);

		int filesCount=model.getFilesCount();
		callableStatement.setInt(17, filesCount);

		int notesCount=model.getNotesCount();
		callableStatement.setInt(18, notesCount);

		int followersCount=model.getFollowersCount();
		callableStatement.setInt(19, followersCount);

		int wonDealsCount=model.getWonDealsCount();
		callableStatement.setInt(20, wonDealsCount);

		int relatedWonDealsCount=model.getRelatedWonDealsCount();
		callableStatement.setInt(21, relatedWonDealsCount);

		int lostDealsCount=model.getLostDealsCount();
		callableStatement.setInt(22, lostDealsCount);

		int relatedLostDealsCount=model.getRelatedLostDealsCount();
		callableStatement.setInt(23, relatedLostDealsCount);

		boolean activeFlag=model.getActiveFlag();
		callableStatement.setBoolean(24, activeFlag);

		String firstChar=model.getFirstChar();
		callableStatement.setString(25, firstChar);

		int visibleTo=model.getVisibleTo();
		callableStatement.setInt(26, visibleTo);

		int pictureId=model.getPictureId();
		callableStatement.setInt(27, pictureId);

		String nextActivityDate=model.getNextActivityDate();
		callableStatement.setString(28, nextActivityDate);

		String nextActivityTime=model.getNextActivityTime();
		callableStatement.setString(29, nextActivityTime);

		int nextActivityId=model.getNextActivityId();
		callableStatement.setInt(30, nextActivityId);

		int lastActivityId=model.getLastActivityId();
		callableStatement.setInt(31, lastActivityId);

		String lastActivityDate=model.getLastActivityDate();
		callableStatement.setString(32, lastActivityDate);

		String timeLineLastActivityTime=model.getTimeLineLastActivityTime();
		callableStatement.setString(33, timeLineLastActivityTime);

		String timeLineLastActivityTimeByOwner=model.getTimeLineLastActivityTimeByOwner();
		callableStatement.setString(34, timeLineLastActivityTimeByOwner);

		String lastIncomingMailTime=model.getLastIncomingMailTime();
		callableStatement.setString(35, lastIncomingMailTime);

		String lastOutgoingMailTime=model.getLastOutgoingMailTime();
		callableStatement.setString(36, lastOutgoingMailTime);

		String postalAddress=model.getPostalAddress();
		callableStatement.setString(37, postalAddress);
		
		String postalAddressSubpremise=model.getPostalAddressSubpremise();
		callableStatement.setString(38, postalAddressSubpremise);

		String postalAddressStreetNumber=model.getPostalAddressStreetNumber();
		callableStatement.setString(39, postalAddressStreetNumber);

		String postalAddressRoute=model.getPostalAddressRoute();
		callableStatement.setString(40, postalAddressRoute);

		String postalAddressSubLocality=model.getPostalAddressSubLocality();
		callableStatement.setString(41, postalAddressSubLocality);

		String postalAddressLocality=model.getPostalAddressLocality();
		callableStatement.setString(42, postalAddressLocality);

		String postalAddressAdminAreaLevel1=model.getPostalAddressAdminAreaLevel1();
		callableStatement.setString(43, postalAddressAdminAreaLevel1);

		String postalAddressAdminAreaLevel2=model.getPostalAddressAdminAreaLevel2();
		callableStatement.setString(44, postalAddressAdminAreaLevel2);

		String postalAddressCountry=model.getPostalAddressCountry();
		callableStatement.setString(45, postalAddressCountry);

		String postalAddressPostalCode=model.getPostalAddressPostalCode();
		callableStatement.setString(46, postalAddressPostalCode);

		String postalAddressFormattedAddress=model.getPostalAddressFormatAddress();
		callableStatement.setString(47, postalAddressFormattedAddress);

		String orgName=model.getOrgName();
		callableStatement.setString(48, orgName);

		String cCEmail=model.getCCEmail();
		callableStatement.setString(49, cCEmail);

		int personId=model.getPersonId();
		callableStatement.setInt(50, personId);

		
		int count = callableStatement.executeUpdate();
		if(count>0){
			response=(GetPersonByUserProfileIdClass.getPersonByUserProfileId(userProfileId));
		}else{
			response.setIsSuccess(false);
			response.setMessage("Person is not updated");
			response.setPersonList(null);
		}
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		if(connection!=null){
			try{
				connection.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		if(callableStatement!=null){
			try{
				callableStatement.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	return response;
}
}
