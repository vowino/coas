package cs.mum.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs.mum.dao.IApplicantDAO;
import cs.mum.mb.Helper;
import cs.mum.model.Applicant;
@Service
public class ApplicantService {
	@Autowired
	private IApplicantDAO applicantDao;

	public void setApplicantDao(IApplicantDAO applicantDao) {
		this.applicantDao = applicantDao;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, readOnly = true)
	public List<Applicant> getApplicants() {
		return applicantDao.getAllApplicant();
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Applicant getApplicantById(long id) {
		return applicantDao.getApplicantById(id);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insertApplicant(Applicant applicant) {
		applicant.setCreationDate(new Date());
		applicant.setRegVerification(Helper.md5((String.valueOf(applicant.getCreationDate()))));
		applicantDao.insert(applicant);
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void updateApplicant(Applicant applicant) {
		applicantDao.insert(applicant);
	}
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public Applicant getApplicantByRegVerify(String regVerify) {
		return applicantDao.getApplicantByRegVerify(regVerify);
	}
}
