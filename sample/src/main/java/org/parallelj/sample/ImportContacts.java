package org.parallelj.sample;

import java.util.Collection;

import javax.annotation.Generated;

import org.apache.log4j.Logger;
import org.parallelj.AndJoin;
import org.parallelj.AndSplit;
import org.parallelj.Begin;
import org.parallelj.Capacity;
import org.parallelj.ForEach;
import org.parallelj.Program;
import org.parallelj.launching.QuartzExecution;
import org.parallelj.sample.csv.ContactLine;
import org.parallelj.sample.steps.Initialize;
import org.parallelj.sample.steps.Processor;
import org.parallelj.sample.steps.Validate;

/**
 * Program org.parallelj.sample.ImportContacts Description :
 **/
@QuartzExecution
@Generated("//J")
@Program
@Capacity(-1)
public class ImportContacts {
	/**
	 * contacts field Description :
	 **/
	Collection<ContactLine> contacts;

	Logger logger;

	long start = System.currentTimeMillis();

	long tmp;

	/**
	 * Entry method of procedure initialize. This procedure is bound to
	 * org.parallelj.sample.steps.Initialize Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-198555218")
	@Begin
	public Initialize initialize() {
		return new Initialize();
	}

	/**
	 * Exit method of procedure initialize. This procedure is bound to
	 * org.parallelj.sample.steps.Initialize Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "process" })
	public void initialize(Initialize executable) {
		this.contacts = executable.getResolvedContacts();
		this.logger = executable.getLogger();
		tmp = System.currentTimeMillis();
		this.logger.info("Initialize: OK. (" + (tmp - start) + " ms)");
	}

	/**
	 * Entry method of procedure process. This procedure is bound to
	 * org.parallelj.sample.steps.Processor Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "781881102")
	@AndJoin
	@Capacity(15)
	public Processor process(@ForEach("contacts") ContactLine val) {
		Processor processor = new Processor();
		processor.setContact(val);
		return processor;
	}

	/**
	 * Exit method of procedure process. This procedure is bound to
	 * org.parallelj.sample.steps.Processor Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "validate" })
	public void process(Processor executable) {
	}

	/**
	 * Entry method of procedure validate. This procedure is bound to
	 * org.parallelj.sample.steps.Validate Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-1502304524")
	@AndJoin
	public Validate validate() {
		long tmp2 = System.currentTimeMillis();
		this.logger.info("Process: OK. (" + (tmp2 - tmp) + " ms)");
		tmp = tmp2;
		return new Validate();
	}

	/**
	 * Exit method of procedure validate. This procedure is bound to
	 * org.parallelj.sample.steps.Validate Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "end" })
	public void validate(Validate executable) {
		boolean ok = executable.isOk();
		this.logger.info("Validation: " + ok + ". ("
				+ (System.currentTimeMillis() - tmp) + " ms)");
		this.logger.info("Total time: " + (System.currentTimeMillis() - start)
				+ " ms");
	}
}
