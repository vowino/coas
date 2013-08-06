package cs.mum.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import cs.mum.model.Applicant;
import cs.mum.model.ApplicantLogin;

public class ApplicantLoginDAO implements IApplicantLoginDAO {
	@Autowired
	private SessionFactory sf;

	public void setSessionFactory(SessionFactory sf) {
		this.sf = sf;
	}

	public void insert(ApplicantLogin applicant) {
		sf.getCurrentSession().saveOrUpdate(applicant);
	}

	public List<ApplicantLogin> getAllApplicantLogin() {

		@SuppressWarnings("unchecked")
		List<ApplicantLogin> applicant = sf.getCurrentSession()
				.createQuery("from ApplicantLogin").list();

		return applicant;
	}

	@Override
	public ApplicantLogin getApplicationLoginById(long id) {
		ApplicantLogin applicant = (ApplicantLogin) sf.getCurrentSession().get(
				Applicant.class, id);
		return applicant;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicantLogin> getApplicantLoginByUsernamePassword(String userName,
			String passWord) {
		String sql="from ApplicantLogin l where l.userName=:username " +
				"and l.password=MD5(:password) and l.applicant.status=1";
		Query query=sf.getCurrentSession().createQuery(sql);
		query.setParameter("username", userName);
		query.setParameter("password", passWord);
		
		return  query.list();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ApplicantLogin> getApplicantByEmailAddress(String username) {
		String sql = "FROM ApplicantLogin WHERE userName=:username";
		Query query = sf.getCurrentSession().createQuery(sql);
		query.setParameter("username", username);
		return query.list();
	}

	@Override
	public ApplicantLogin getApplicantLoginByCdatePassword(String cdate, String pwd) {
		String sql = "FROM ApplicantLogin l WHERE password=:pwd and l.applicant.creationDate=:cdate";
		Query query = sf.getCurrentSession().createQuery(sql);
		query.setParameter("pwd", pwd);
		query.setParameter("cdate", cdate);
		return (ApplicantLogin)query.uniqueResult();
	}

}
