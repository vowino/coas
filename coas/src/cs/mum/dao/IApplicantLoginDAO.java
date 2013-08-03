package cs.mum.dao;

import java.util.List;

import cs.mum.model.ApplicantLogin;

public interface IApplicantLoginDAO {
	public ApplicantLogin getApplicationLoginById(long id);

	public List<ApplicantLogin> getAllApplicantLogin();

	public void insert(ApplicantLogin applicantLogin);
	
	public List<ApplicantLogin> getApplicantLoginByUsernamePassword(String userName,String passWord);
	
	public List<ApplicantLogin> getApplicantByEmailAddress(String username);

}
