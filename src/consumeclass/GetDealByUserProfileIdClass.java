package consumeclass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dbconstants.DealsDBConstants;
import model.DealModel;
import response.DealResponse;
import utils.Constants;

public class GetDealByUserProfileIdClass {
	private static ArrayList<DealModel>dealList=new ArrayList<DealModel>();
public static DealResponse getDealByUserProfileId(int UserProfileId){
	DealResponse response=new DealResponse();
	Connection connection=null;
	Statement st=null;
	dealList.clear();
	try{
		Class.forName("com.mysql.jdbc.Driver");
	}catch(Exception e){
		e.printStackTrace();
	}
	try{
		String query="CALL `Company.Deal_GetCompanyByUserProfileId`("+UserProfileId+");";
		System.out.println("Query : "+query);
		connection=DriverManager.getConnection(Constants.URL,Constants.USER,Constants.PASSWORD);
		st=connection.createStatement();
		ResultSet rs=st.executeQuery(query);
		while(rs.next()){
			DealModel model=new DealModel();
			int dealId=rs.getInt(DealsDBConstants.DEAL_ID);
			model.setDealId(dealId);
			String title=rs.getString(DealsDBConstants.TITLE);
			model.setTitle(title);
			String status=rs.getString(DealsDBConstants.STATUS);
			model.setStatus(status);
			int value=rs.getInt(DealsDBConstants.VALUE);
			model.setValue(value);
			String currency=rs.getString(DealsDBConstants.CURRENCY);
			model.setCurrency(currency);
			int stageId=rs.getInt(DealsDBConstants.STAGE_ID);
			model.setStageId(stageId);
			int pipeLineId=rs.getInt(DealsDBConstants.PIPE_LINE_ID);
			model.setPipeLineId(pipeLineId);
			int userProfileId=rs.getInt(DealsDBConstants.USER_PROFILE_ID);
			model.setUserProfileId(userProfileId);
			int personId=rs.getInt(DealsDBConstants.PERSON_ID);
			model.setPersonId(personId);
			int organizationId=rs.getInt(DealsDBConstants.ORGANIZATION_ID);
			model.setOrganizationId(organizationId);
			String addTime=rs.getString(DealsDBConstants.ADD_TIME);
			model.setAddTime(addTime);
			String updateTime=rs.getString(DealsDBConstants.UPDATE_TIME);
			model.setUpdateTime(updateTime);
			String stageChangeTime=rs.getString(DealsDBConstants.STAGE_CHANGE_TIME);
			model.setStageChangeTime(stageChangeTime);
			boolean active=rs.getBoolean(DealsDBConstants.ACTIVE);
			model.setActive(active);
			boolean deleted=rs.getBoolean(DealsDBConstants.DELETED);
			model.setDeleted(deleted);
			String probability=rs.getString(DealsDBConstants.PROBABILITY);
			model.setProbability(probability);
			String nextActivityDate=rs.getString(DealsDBConstants.NEXT_ACTIVITY_DATE);
			model.setNextActivityDate(nextActivityDate);
			String nextActivityTime=rs.getString(DealsDBConstants.NEXT_ACTIVITY_TIME);
			model.setNextActivityTime(nextActivityTime);
			int nextActivityId=rs.getInt(DealsDBConstants.NEXT_ACTIVITY_ID);
			model.setNextActivityId(nextActivityId);
			int lastActivityId=rs.getInt(DealsDBConstants.LAST_ACTIVITY_ID);
			model.setLastActivityId(lastActivityId);
			String lastActivityDate=rs.getString(DealsDBConstants.LAST_ACTIVITY_DATE);
			model.setLastActivityDate(lastActivityDate);
			String lostReason=rs.getString(DealsDBConstants.LOST_REASON);
			model.setLostReason(lostReason);
			int visibleTo=rs.getInt(DealsDBConstants.VISIBLE_TO);
			model.setVisibleTo(visibleTo);
			String closeTime=rs.getString(DealsDBConstants.CLOSE_TIME);
			model.setCloseTime(closeTime);
			String wonTime=rs.getString(DealsDBConstants.WON_TIME);
			model.setWonTime(wonTime);
			String firstWonTime=rs.getString(DealsDBConstants.FIRST_WON_TIME);
			model.setFirstWonTime(firstWonTime);
			String lostTime=rs.getString(DealsDBConstants.LOST_TIME);
			model.setLostTime(lostTime);
			int productsCount=rs.getInt(DealsDBConstants.PRODUCTS_COUNT);
			model.setProductsCount(productsCount);
			int filesCount=rs.getInt(DealsDBConstants.FILES_COUNT);
			model.setFilesCount(filesCount);
			int notesCount=rs.getInt(DealsDBConstants.NOTES_COUNT);
			model.setNotescount(notesCount);
			int followersCount=rs.getInt(DealsDBConstants.FOLLOWERS_COUNT);
			model.setFollowersCount(followersCount);
			int emailMessagesCount=rs.getInt(DealsDBConstants.EMAIL_MESSAGES_COUNT);
			model.setEmailMessagesCount(emailMessagesCount);
			int activitiesCount=rs.getInt(DealsDBConstants.ACTIVITIES_COUNT);
			model.setActivitiesCount(activitiesCount);
			int doneActivitiesCount=rs.getInt(DealsDBConstants.DONE_ACTIVITIES_COUNT);
			model.setDoneActivitiesCount(doneActivitiesCount);
			int undoneActivitiesCount=rs.getInt(DealsDBConstants.UN_DONE_ACTIVITIES_COUNT);
			model.setUndoneActivitiesCount(undoneActivitiesCount);
			int referenceActivitiesCount=rs.getInt(DealsDBConstants.REFERENCE_ACTIVITIES_COUNT);
			model.setReferenceActivitiesCount(referenceActivitiesCount);
			int participantsCount=rs.getInt(DealsDBConstants.PARTICIPANTS_COUNT);
			model.setParticipantsCount(participantsCount);
			String expectedCloseDate=rs.getString(DealsDBConstants.EXPETED_CLOSE_DATE);
			model.setExpectedCloseDate(expectedCloseDate);
			String lastIncomingMailTime=rs.getString(DealsDBConstants.LAST_INCOMING_MAIL_TIME);
			model.setLastIncomingMailTime(lastIncomingMailTime);
			String lastOutgoingMailTime=rs.getString(DealsDBConstants.LAST_OUTGOING_MAIL_TIME);
			model.setLastOutgoingMailTime(lastOutgoingMailTime);
			int stageOrderNr=rs.getInt(DealsDBConstants.STAGE_ORDER_NR);
			model.setStageOrderNr(stageOrderNr);
			String personName=rs.getString(DealsDBConstants.PERSON_NAME);
			model.setPersonName(personName);
			String orgName=rs.getString(DealsDBConstants.ORG_NAME);
			model.setOrgName(orgName);
			String nextActivitySubject=rs.getString(DealsDBConstants.NEXT_ACTIVITY_SUBJECT);
			model.setNextActivitySubject(nextActivitySubject);
			String nextActivityType=rs.getString(DealsDBConstants.NEXT_ACTIVITY_TYPE);
			model.setNextActivityType(nextActivityType);
			String nextActivityDuration=rs.getString(DealsDBConstants.NEXT_ACTIVITY_DURATION);
			model.setNextActivityDuration(nextActivityDuration);
			String nextActivityNote=rs.getString(DealsDBConstants.NEXT_ACTIVITY_NOTE);
			model.setNextActivityNote(nextActivityNote);
			String formattedValue=rs.getString(DealsDBConstants.FORMATTED_VALUE);
			model.setFormattedValue(formattedValue);
			String rottenTime=rs.getString(DealsDBConstants.ROTTEN_TIME);
			model.setRottenTime(rottenTime);
			int weightedValue=rs.getInt(DealsDBConstants.WEIGHTED_VALUE);
			model.setWeightedValue(weightedValue);
			String formattedWeightedValue=rs.getString(DealsDBConstants.FORMATTED_WEIGHTED_VALUE);
			model.setFormattedWeightedValue(formattedWeightedValue);
			String ownerName=rs.getString(DealsDBConstants.OWNER_NAME);
			model.setOwnerName(ownerName);
			String cCEmail=rs.getString(DealsDBConstants.CC_EMAIL);
			model.setcCEmail(cCEmail);
			boolean orgHidden=rs.getBoolean(DealsDBConstants.ORG_HIDDEN);
			model.setOrgHidden(orgHidden);
			boolean personHidden=rs.getBoolean(DealsDBConstants.PERSON_HIDDEN);
			model.setPersonHidden(personHidden);
			
			dealList.add(model);
			
		}
		if(dealList!=null&& dealList.size()!=0){
			response.setIsSuccess(true);
			response.setMessage("");
			response.setDealList(dealList);
		}else{
			response.setIsSuccess(false);
			response.setMessage("deal list is emppty or null");
			response.setDealList(null);
			
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
		if(st!=null){
			try {
				st.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	return response;
}
}
