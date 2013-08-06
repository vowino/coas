package cs.mum.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cs.mum.model.Applicant;
public class ApplicantDAO implements IApplicantDAO{
	@Autowired
	private SessionFactory sf;

	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}

	public void insert(Applicant applicant) {
		sf.getCurrentSession().saveOrUpdate(applicant);
	}

	public List<Applicant> getAllApplicant() {

		@SuppressWarnings("unchecked")
		List<Applicant> applicant = sf.getCurrentSession()
				.createQuery("from Applicant").list();

		return applicant;
	}

	public Applicant getApplicantById(long id) {
		Applicant applicant = (Applicant) sf.getCurrentSession().get(
				Applicant.class, id);
		return applicant;

	}

	@Override
	public Applicant getApplicationById(long id) {
		return null;
	}

	@Override
	public Applicant getApplicantByRegVerify(String regVerify) {
		String sql = "from Applicant where regVerification=:pregVerify";
		Query query = sf.getCurrentSession().createQuery(sql);
		query.setParameter("pregVerify", regVerify);
		return (Applicant)query.uniqueResult();
	}

}
