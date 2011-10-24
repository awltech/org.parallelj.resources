package org.parallelj.example;

import java.util.ArrayList;
import java.util.Collection;
import javax.annotation.Generated;
import org.parallelj.AndJoin;
import org.parallelj.AndSplit;
import org.parallelj.Begin;
import org.parallelj.Link;
import org.parallelj.Program;
import org.parallelj.XorJoin;
import org.parallelj.XorSplit;
import org.parallelj.Capacity;
import org.parallelj.ForEach;

/**
 * Program org.parallelj.example.Demo Description :
 **/
@Generated("//J")
@Program
public class Demo {
	private Collection<String> data = new ArrayList<String>();

	private void init() {
		for (int i = 0; i < 10; i++)
			data.add("data" + i);
	}

	/**
	 * Entry method of procedure procedure1. This procedure is bound to
	 * org.parallelj.example.MyExecutable Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "316001396")
	@Begin
	public MyExecutable procedure1() {
		this.init();
		return new MyExecutable("procedure1");
	}

	/**
	 * Exit method of procedure procedure1. This procedure is bound to
	 * org.parallelj.example.MyExecutable Description :
	 * 
	 * @generated //J
	 */
	@XorSplit({ @Link(predicate = "predicate1", to = "procedure2"),
			@Link(predicate = "predicate2", to = "procedure3"),
			@Link(predicate = "", to = "procedure4") })
	@Generated(value = "//J", comments = "3677788")
	public void procedure1(MyExecutable executable) {
	}

	/**
	 * Entry method of procedure procedure2. This procedure is bound to
	 * org.parallelj.example.MyExecutable Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "316001396")
	@AndJoin
	public MyExecutable procedure2() {
		return new MyExecutable("procedure2");
	}

	/**
	 * Exit method of procedure procedure2. This procedure is bound to
	 * org.parallelj.example.MyExecutable Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "procedure5" })
	public void procedure2(MyExecutable executable) {
	}

	/**
	 * Entry method of procedure procedure3. This procedure is bound to
	 * org.parallelj.example.MyExecutable Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "316001396")
	@AndJoin
	public MyExecutable procedure3() {
		return new MyExecutable("procedure3");
	}

	/**
	 * Exit method of procedure procedure3. This procedure is bound to
	 * org.parallelj.example.MyExecutable Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "procedure5" })
	public void procedure3(MyExecutable executable) {
	}

	/**
	 * Entry method of procedure procedure4. This procedure is bound to
	 * org.parallelj.example.MyExecutable Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "316001396")
	@AndJoin
	public MyExecutable procedure4() {
		return new MyExecutable("procedure4");
	}

	/**
	 * Exit method of procedure procedure4. This procedure is bound to
	 * org.parallelj.example.MyExecutable Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "procedure5" })
	public void procedure4(MyExecutable executable) {
	}

	/**
	 * Entry method of procedure procedure5. This procedure is bound to
	 * org.parallelj.example.MyExecutable Description :
	 * 
	 * @generated //J
	 */
	@XorJoin
	@Generated(value = "//J", comments = "316001396")
	public MyExecutable procedure5() {
		return new MyExecutable("procedure5");
	}

	/**
	 * Exit method of procedure procedure5. This procedure is bound to
	 * org.parallelj.example.MyExecutable Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "process" })
	public void procedure5(MyExecutable executable) {
	}

	/**
	 * Predicate predicate2 Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-1225371522")
	public boolean isPredicate2() {
		return true;
	}

	/**
	 * Predicate predicate1 Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-1225371522")
	public boolean isPredicate1() {
		return false;
	}

	/**
	 * Entry method of procedure process. This procedure is bound to
	 * org.parallelj.example.ParallelProcessor Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "-1132520697")
	@AndJoin
	@Capacity(10)
	public ParallelProcessor process(@ForEach("data") String val) {
		return new ParallelProcessor(val);
	}

	/**
	 * Exit method of procedure process. This procedure is bound to
	 * org.parallelj.example.ParallelProcessor Description :
	 * 
	 * @generated //J
	 */
	@Generated(value = "//J", comments = "3677788")
	@AndSplit({ "end" })
	public void process(ParallelProcessor executable) {
	}
}
