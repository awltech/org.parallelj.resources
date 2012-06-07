package org.parallelj.sample.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PersistenceHelper {

	private static final String PERSISTENCE_UNIT = "org.parallelj.sample";

	protected static EntityManagerFactory emf = Persistence
			.createEntityManagerFactory(PERSISTENCE_UNIT);

	public static void dispose() {
		emf.close();
	}

	public static TransactionManager getTransactionManager() {
		return new TransactionManager();
	}

	public static class TransactionManager {

		private EntityManager em;
		private EntityTransaction t;

		public TransactionManager init() {
			this.em = PersistenceHelper.emf.createEntityManager();
			this.t = this.em.getTransaction();
			return this;
		}

		public TransactionManager begin() {
			this.t.begin();
			return this;
		}

		public EntityManager getEntityManager() {
			return this.em;
		}

		public EntityTransaction getEntityTransaction() {
			return this.t;
		}

		public TransactionManager commit() {
			this.t.commit();
			return this;
		}

		public void close() {
			this.em.close();
		}

	}

}
