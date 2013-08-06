package cs.mum.dao;

import java.util.List;

import cs.mum.model.Applicant;

public interface IApplicantDAO {
	public Applicant getApplicationById(long id);

	public List<Applicant> getAllApplicant();

	public void insert(Applicant applicant);
	
	public Applicant getApplicantById(long id);
	
	public Applicant getApplicantByRegVerify(String regVerify);
	
}
