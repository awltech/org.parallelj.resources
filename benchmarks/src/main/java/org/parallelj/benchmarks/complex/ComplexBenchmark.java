package org.parallelj.benchmarks.complex;

import java.util.Collection;

import javax.annotation.Generated;

import org.apache.log4j.Logger;
import org.parallelj.AndJoin;
import org.parallelj.AndSplit;
import org.parallelj.Begin;
import org.parallelj.Capacity;
import org.parallelj.ForEach;
import org.parallelj.Program;
import org.parallelj.benchmarks.complex.steps.Initialize;
import org.parallelj.benchmarks.complex.steps.Lock;
import org.parallelj.benchmarks.complex.steps.Prepare;
import org.parallelj.benchmarks.complex.steps.Process;
import org.parallelj.benchmarks.complex.steps.Terminate;
import org.parallelj.launching.In;
import org.parallelj.launching.QuartzExecution;

/**
 * Program org.parallelj.benchmarks.complex.ComplexBenchmark Description :
 **/
@QuartzExecution
@Generated("//J")
@Program
public class ComplexBenchmark {
	public void setArraySize(int arraySize) {
		this.arraySize = arraySize;
	}

	public void setLoopSize(int loopSize) {
		this.loopSize = loopSize;
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
	 * start field Description :
	 **/
	Long start;
	/**
	 * logger field Description :
	 **/
	Logger logger;
	/**
	 * data1 field Description :
	 **/
	Collection<Integer> data1;
	/**
	 * data2 field Description :
	 **/
	Collection<Integer> data2;
	/**
	 * data3 field Description :
	 **/
	Collection<Integer> data3;

	/**
	 * Entry method of procedure prepare. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Prepare Description :
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
	 * org.parallelj.benchmarks.complex.steps.Prepare Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "initialize1", "initialize2", "initialize3" })
	public void prepare(Prepare executable) {
		this.start = executable.getStart();
		this.logger = executable.getLogger();
	}

	/**
	 * Entry method of procedure initialize1. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Initialize Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-198555218")
	@AndJoin
	public Initialize initialize1() {
		Initialize initialize = new Initialize();
		initialize.setArraySize(this.arraySize);
		return initialize;
	}

	/**
	 * Exit method of procedure initialize1. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Initialize Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "process1" })
	public void initialize1(Initialize executable) {
		this.data1 = executable.getData();
	}

	/**
	 * Entry method of procedure initialize2. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Initialize Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-198555218")
	@AndJoin
	public Initialize initialize2() {
		Initialize initialize = new Initialize();
		initialize.setArraySize(this.arraySize);
		return initialize;
	}

	/**
	 * Exit method of procedure initialize2. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Initialize Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "process2" })
	public void initialize2(Initialize executable) {
		this.data2 = executable.getData();
	}

	/**
	 * Entry method of procedure initialize3. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Initialize Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-198555218")
	@AndJoin
	public Initialize initialize3() {
		Initialize initialize = new Initialize();
		initialize.setArraySize(this.arraySize);
		return initialize;
	}

	/**
	 * Exit method of procedure initialize3. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Initialize Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "process3" })
	public void initialize3(Initialize executable) {
		this.data3 = executable.getData();
	}

	/**
	 * Exit method of procedure process1. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Process Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "lock" })
	public void process1(Process executable) {

	}

	/**
	 * Exit method of procedure process2. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Process Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "lock" })
	public void process2(Process executable) {

	}

	/**
	 * Exit method of procedure process3. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Process Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "lock" })
	public void process3(Process executable) {
	}

	/**
	 * Entry method of procedure lock. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Lock Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "1112930249")
	@AndJoin
	public Lock lock() {
		return new Lock();
	}

	/**
	 * Exit method of procedure lock. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Lock Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "terminate" })
	public void lock(Lock executable) {
	}

	/**
	 * Entry method of procedure terminate. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Terminate Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-1354290787")
	@AndJoin
	public Terminate terminate() {
		Terminate terminate = new Terminate();
		terminate.setLogger(this.logger);
		terminate.setStart(this.start);
		return terminate;
	}

	/**
	 * Exit method of procedure terminate. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Terminate Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "end" })
	public void terminate(Terminate executable) {
	}

	/**
	 * Entry method of procedure process3. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Process Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-668568853")
	@AndJoin
	@Capacity(5)
	public Process process3(@ForEach("data3") Integer val) {
		Process process = new Process();
		process.setInput(val);
		process.setLoopSize(this.loopSize);
		return process;
	}

	/**
	 * Entry method of procedure process2. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Process Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-668568853")
	@AndJoin
	@Capacity(5)
	public Process process2(@ForEach("data2") Integer val) {
		Process process = new Process();
		process.setInput(val);
		process.setLoopSize(this.loopSize);
		return process;
	}

	/**
	 * Entry method of procedure process1. This procedure is bound to
	 * org.parallelj.benchmarks.complex.steps.Process Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-668568853")
	@AndJoin
	@Capacity(5)
	public Process process1(@ForEach("data1") Integer val) {
		Process process = new Process();
		process.setInput(val);
		process.setLoopSize(this.loopSize);
		return process;
	}
}
