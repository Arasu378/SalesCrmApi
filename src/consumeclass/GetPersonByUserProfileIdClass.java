package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Constants;

import dbconstants.PersonDBConstants;
import model.PersonEmailModel;
import model.PersonModel;
import model.PersonPhoneModel;
import response.PersonResponse;

public class GetPersonByUserProfileIdClass {
	private static ArrayList<PersonModel>personList=new ArrayList<PersonModel>();
	public static PersonResponse getPersonByUserProfileId(int UserProfileId){
		PersonResponse response=new PersonResponse();
		personList.clear();
		Connection connection=null;
		Statement statement=null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		try{
			String query="CALL `UserSettings.Person_GetPersonByUserProfileId`("+UserProfileId+");";
			System.out.println("Query : "+query);
			connection=DriverManager.getConnection(utils.Constants.URL,utils.Constants.USER,utils.Constants.PASSWORD);
			statement=connection.createStatement();
			ResultSet rs=statement.executeQuery(query);
			while(rs.next()){
				PersonModel model=new PersonModel();
				int personId=rs.getInt(PersonDBConstants.ID);
				model.setPersonId(personId);
				ArrayList<PersonPhoneModel>personPhoneList=GetPersonPhoneByPersonIdClass.getPersonPhoneList(personId);
				model.setPersonPhoneList(personPhoneList);
				ArrayList<PersonEmailModel>personEmailList=GetPersonEmailByPersonIdClass.getPersonEmailList(personId);
				model.setPersonEmailList(personEmailList);
				String userName=rs.getString(PersonDBConstants.USER_NAME);
				if(userName==null){
					userName="";
				}
				model.setUserName(userName);
				String createdDate=rs.getString(PersonDBConstants.CREATED_DATE);
				if(createdDate==null){
					createdDate="";
				}
				model.setCreatedDate(createdDate);
				String modifiedDate=rs.getString(PersonDBConstants.MODIFIED_DATE);
				if(modifiedDate==null){
					modifiedDate="";
				}
				model.setModifiedDate(modifiedDate);
				int userProfileId=rs.getInt(PersonDBConstants.USER_PROFILE_ID);
				model.setUserProfileId(userProfileId);
				String companyCode=rs.getString(PersonDBConstants.COMPANY_CODE);
				if(companyCode==null){
					companyCode="";
				}
				model.setCompanyCode(companyCode);
				int orgId=rs.getInt(PersonDBConstants.ORG_ID);
				model.setOrgId(orgId);
				String name=rs.getString(PersonDBConstants.NAME);
				if(name==null){
					name="";
				}
				model.setName(name);
				String firstName=rs.getString(PersonDBConstants.FIRST_NAME);
				if(firstName==null){
					firstName="";
				}
				model.setFirstName(firstName);
				String lastName=rs.getString(PersonDBConstants.LAST_NAME);
				if(lastName==null){
					lastName="";
				}
				model.setLastName(lastName);
				int openDealsCount=rs.getInt(PersonDBConstants.OPEN_DEALS_COUNT);
				model.setOpenDealsCount(openDealsCount);
				int relatedOpenDealsCount=rs.getInt(PersonDBConstants.RELATED_OPEN_DEALS_COUNT);
				model.setRelatedOpenDealsCount(relatedOpenDealsCount);
				int participantOpenDealsCount=rs.getInt(PersonDBConstants.PARTICIPANT_OPEN_DEALS_COUNT);
				model.setParticipantOpenDealsCount(participantOpenDealsCount);
				int participantsClosedDealsCount=rs.getInt(PersonDBConstants.PARTICIPANT_CLOSE_DEALS_COUNT);
				model.setParticipantsClosedDealsCount(participantsClosedDealsCount);
				int emailMessagesCount=rs.getInt(PersonDBConstants.EMAIL_MESSAGES_COUNT);
				model.setEmailMessagesCount(emailMessagesCount);
				int activitiesCount=rs.getInt(PersonDBConstants.ACTIVITIES_COUNT);
				model.setActivitiesCount(activitiesCount);
				int doneActivitiesCount=rs.getInt(PersonDBConstants.DONE_ACTIVITIES_COUNT);
				model.setDoneActivitiesCount(doneActivitiesCount);
				int undoneActivitiesCount=rs.getInt(PersonDBConstants.UNDONE_ACTIVITIES_COUNT);
				model.setUndoneActivitiesCount(undoneActivitiesCount);
				int referenceActivitiesCount=rs.getInt(PersonDBConstants.REFERENCE_ACTIVITIES_COUNT);
				model.setReferenceActivitiesCount(referenceActivitiesCount);
				int filesCount=rs.getInt(PersonDBConstants.FILES_COUNT);
				model.setFilesCount(filesCount);
				int notesCount=rs.getInt(PersonDBConstants.NOTES_COUNT);
				model.setNotesCount(notesCount);
				int followersCount=rs.getInt(PersonDBConstants.FOLLOWERS_COUNT);
				model.setFollowersCount(followersCount);
				int wonDealsCount=rs.getInt(PersonDBConstants.WON_DEALS_COUNT);
				model.setWonDealsCount(wonDealsCount);
				int relatedWonDealsCount=rs.getInt(PersonDBConstants.RELATED_WON_DEALS_COUNT);
				model.setRelatedWonDealsCount(relatedWonDealsCount);
				int lostDealsCount=rs.getInt(PersonDBConstants.LOST_DEALS_COUNT);
				model.setLostDealsCount(lostDealsCount);
				int relatedLostDealsCount=rs.getInt(PersonDBConstants.RelatedLostDealsCount);
				model.setRelatedLostDealsCount(relatedLostDealsCount);
				boolean activeFlag=rs.getBoolean(PersonDBConstants.ACTIVE_FLAG);
				model.setActiveFlag(activeFlag);
				String firstChar=rs.getString(PersonDBConstants.FIRST_CHAR);
				if(firstChar==null){
					firstChar="";
				}
				model.setFirstChar(firstChar);
				int visibleTo=rs.getInt(PersonDBConstants.VISIBLE_TO);
				model.setVisibleTo(visibleTo);
				int pictureId=rs.getInt(PersonDBConstants.PICTURE_ID);
				model.setPictureId(pictureId);
				String nextActivityDate=rs.getString(PersonDBConstants.NEXT_ACTIVITY_DATE);
				if(nextActivityDate==null){
					nextActivityDate="";
				}
				model.setNextActivityDate(nextActivityDate);
				String nextActivityTime=rs.getString(PersonDBConstants.NEXT_ACTIVITY_TIME);
				if(nextActivityTime==null){
					nextActivityTime="";
				}
				model.setNextActivityTime(nextActivityTime);
				int nextActivityId=rs.getInt(PersonDBConstants.NEXT_ACTIVITY_ID);
				model.setNextActivityId(nextActivityId);
				int lastActivityId=rs.getInt(PersonDBConstants.LAST_ACTIVITY_ID);
				model.setLastActivityId(lastActivityId);
				String lastActivityDate=rs.getString(PersonDBConstants.LAST_ACTIVITY_DATE);
				if(lastActivityDate==null){
					lastActivityDate="";
				}
				model.setLastActivityDate(lastActivityDate);
				String timeLineLastActivityTime=rs.getString(PersonDBConstants.TIME_LINE_LAST_ACTIVITY_TIME);
				if(timeLineLastActivityTime==null){
					timeLineLastActivityTime="";
				}
				model.setTimeLineLastActivityTime(timeLineLastActivityTime);
				String timeLineLastActivityTimeByOwner=rs.getString(PersonDBConstants.TIME_LINE_LAST_AVTIVITY_TIME_BYOWNER);
				if(timeLineLastActivityTimeByOwner==null){
					timeLineLastActivityTimeByOwner="";
				}
				model.setTimeLineLastActivityTimeByOwner(timeLineLastActivityTimeByOwner);
				String lastIncomingMailTime=rs.getString(PersonDBConstants.LAST_INCOMING_MAIL_TILE);
				if(lastIncomingMailTime==null){
					lastIncomingMailTime="";
				}
				model.setLastIncomingMailTime(lastIncomingMailTime);
				String lastOutgoingMailTime=rs.getString(PersonDBConstants.LAST_OUTGOING_MAIL_TIME);
				if(lastOutgoingMailTime==null){
					lastOutgoingMailTime="";
				}
				model.setLastOutgoingMailTime(lastOutgoingMailTime);
				String postalAddress=rs.getString(PersonDBConstants.POSTAL_ADDRESS);
				if(postalAddress==null){
					postalAddress="";
				}
				model.setPostalAddress(postalAddress);
				String postalAddressSubpremise=rs.getString(PersonDBConstants.POSTAL_ADDRESS_SUB_PREMISE);
				if(postalAddressSubpremise==null){
					postalAddressSubpremise="";
				}
				model.setPostalAddressSubpremise(postalAddressSubpremise);
				String postalAddressStreetNumber=rs.getString(PersonDBConstants.POSTAL_ADDRESS_STREET_NUMBER);
				if(postalAddressStreetNumber==null){
					postalAddressStreetNumber="";
				}
				model.setPostalAddressStreetNumber(postalAddressStreetNumber);
				String postalAddressRoute=rs.getString(PersonDBConstants.POSTAL_ADDRESS_ROUTE);
				if(postalAddressRoute==null){
					postalAddressRoute="";
				}
				model.setPostalAddressRoute(postalAddressRoute);
				String postalAddressSubLocality=rs.getString(PersonDBConstants.POSTAL_ADDRESS_SUB_LOCALITY);
				if(postalAddressSubLocality==null){
					postalAddressSubLocality="";
				}
				model.setPostalAddressSubLocality(postalAddressSubLocality);
				String postalAddressLocality=rs.getString(PersonDBConstants.POSTAL_ADDRESS_LOCALITY);
				if(postalAddressLocality==null){
					postalAddressLocality="";
				}
				model.setPostalAddressLocality(postalAddressLocality);
				String postalAddressAdminAreaLevel1=rs.getString(PersonDBConstants.POSTAL_ADDRESS_ADMIN_AREA_LEVEL_1);
				if(postalAddressAdminAreaLevel1==null){
					postalAddressAdminAreaLevel1="";
				}
				model.setPostalAddressAdminAreaLevel1(postalAddressAdminAreaLevel1);
				String postalAddressAdminAreaLevel2=rs.getString(PersonDBConstants.POSTAL_ADDRESS_ADMIN_AREA_LEVEL_2);
				if(postalAddressAdminAreaLevel2==null){
					postalAddressAdminAreaLevel2="";
				}
				model.setPostalAddressAdminAreaLevel2(postalAddressAdminAreaLevel2);
				String postalAddressCountry=rs.getString(PersonDBConstants.POSTAL_ADDRESS_COUNTRY);
				if(postalAddressCountry==null){
					postalAddressCountry="";
				}
				model.setPostalAddressCountry(postalAddressCountry);
				String postalAddressPostalCode=rs.getString(PersonDBConstants.POSTAL_ADDRESS_POSTAL_CODE);
				if(postalAddressPostalCode==null){
					postalAddressPostalCode="";
				}
				model.setPostalAddressPostalCode(postalAddressPostalCode);
				String postalAddressFormattedAddress=rs.getString(PersonDBConstants.POSTAL_ADDRESS_FORMATTED_ADDRESS);
				if(postalAddressFormattedAddress==null){
					postalAddressFormattedAddress="";
				}
				model.setPostalAddressFormatAddress(postalAddressFormattedAddress);
				String orgName=rs.getString(PersonDBConstants.ORG_NAME);
				if(orgName==null){
					orgName="";
				}
				model.setOrgName(orgName);
				String cCEmail=rs.getString(PersonDBConstants.CC_EMAIL);
				if(cCEmail==null){
					cCEmail="";
				}
				model.setCCEmail(cCEmail);
				String ownerName=rs.getString(PersonDBConstants.OWNER_NAME);
				if(ownerName==null){
					ownerName="";
				}
				model.setOwnerName(ownerName);
				personList.add(model);
				
			}
			if(personList!=null &&personList.size()!=0){
				response.setIsSuccess(true);
				response.setMessage("");
				response.setPersonList(personList);
			}else{
				response.setIsSuccess(false);
				response.setMessage("person list is empty or null");
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
			if(statement!=null){
				try{
					statement.close();
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		}
		
		return response;
	}

}
