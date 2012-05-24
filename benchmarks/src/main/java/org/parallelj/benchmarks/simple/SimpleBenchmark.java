package org.parallelj.benchmarks.simple;

import java.util.Collection;

import javax.annotation.Generated;

import org.apache.log4j.Logger;
import org.parallelj.AndJoin;
import org.parallelj.AndSplit;
import org.parallelj.Begin;
import org.parallelj.Capacity;
import org.parallelj.ForEach;
import org.parallelj.Program;
import org.parallelj.benchmarks.simple.steps.Initialize;
import org.parallelj.benchmarks.simple.steps.Prepare;
import org.parallelj.benchmarks.simple.steps.Process;
import org.parallelj.benchmarks.simple.steps.Terminate;
import org.parallelj.launching.In;
import org.parallelj.launching.QuartzExecution;

/**
 * Program org.parallelj.benchmarks.simple.SimpleBenchmark Description :
 **/
@QuartzExecution
@Generated("//J")
@Program
public class SimpleBenchmark {

	public void setLoopSize(int loopSize) {
		this.loopSize = loopSize;
	}

	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

	/**
	 * loopSize field Description :
	 **/
	@In
	Integer loopSize;
	/**
	 * arraySize field Description :
	 **/
	@In
	Integer arraySize;
	/**
	 * data field Description :
	 **/
	Collection<Integer> data;
	/**
	 * logger field Description :
	 **/
	Logger logger;
	/**
	 * start field Description :
	 **/
	Long start;

	/**
	 * Entry method of procedure prepare. This procedure is bound to
	 * org.parallelj.benchmarks.simple.steps.Prepare Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-781709437")
	@Begin
	public Prepare prepare() {
		return new Prepare();
	}

	/**
	 * Exit method of procedure prepare. This procedure is bound to
	 * org.parallelj.benchmarks.simple.steps.Prepare Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "initialize" })
	public void prepare(Prepare executable) {
		this.logger = executable.getLogger();
		this.start = executable.getStart();
	}

	/**
	 * Entry method of procedure initialize. This procedure is bound to
	 * org.parallelj.benchmarks.simple.steps.Initialize Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-198555218")
	@AndJoin
	public Initialize initialize() {
		Initialize init = new Initialize();
		init.setArraySize(this.arraySize);
		return init;
	}

	/**
	 * Exit method of procedure initialize. This procedure is bound to
	 * org.parallelj.benchmarks.simple.steps.Initialize Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "process" })
	public void initialize(Initialize executable) {
		this.data = executable.getData();
	}

	/**
	 * Entry method of procedure terminate. This procedure is bound to
	 * org.parallelj.benchmarks.simple.steps.Terminate Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-1354290787")
	@AndJoin
	public Terminate terminate() {
		Terminate term = new Terminate();
		term.setLogger(this.logger);
		term.setStart(this.start);
		return term;
	}

	/**
	 * Exit method of procedure terminate. This procedure is bound to
	 * org.parallelj.benchmarks.simple.steps.Terminate Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "end" })
	public void terminate(Terminate executable) {
	}

	/**
	 * Entry method of procedure process. This procedure is bound to
	 * org.parallelj.benchmarks.simple.steps.Process Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-668568853")
	@AndJoin
	@Capacity(5)
	public Process process(@ForEach("data") Integer val) {
		Process process = new Process();
		process.setInput(val);
		process.setLoopSize(this.loopSize);
		return process;
	}

	/**
	 * Exit method of procedure process. This procedure is bound to
	 * org.parallelj.benchmarks.simple.steps.Process Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "terminate" })
	public void process(Process executable) {

	}
}
