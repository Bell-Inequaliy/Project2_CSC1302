/*
    2    * Copyright (c) 1994, 2010, Oracle and/or its affiliates. All rights reserved.
    3    * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
    4    *
    5    * This code is free software; you can redistribute it and/or modify it
    6    * under the terms of the GNU General Public License version 2 only, as
    7    * published by the Free Software Foundation.  Oracle designates this
    8    * particular file as subject to the "Classpath" exception as provided
    9    * by Oracle in the LICENSE file that accompanied this code.
   10    *
   11    * This code is distributed in the hope that it will be useful, but WITHOUT
   12    * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
   13    * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
   14    * version 2 for more details (a copy is included in the LICENSE file that
   15    * accompanied this code).
   16    *
   17    * You should have received a copy of the GNU General Public License version
   18    * 2 along with this work; if not, write to the Free Software Foundation,
   19    * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
   20    *
   21    * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
   22    * or visit www.oracle.com if you need additional information or have any
   23    * questions.
   24    */

package edu.gsu.csc1302.prj2.somethingrandom;

/**
 * Class {@code Object} is the root of the class hierarchy.
 * Every class has {@code Object} as a superclass. All objects,
 * including arrays, implement the methods of this class.
 *
 * @author  unascribed
 * @see     java.lang.Class
 * @since   JDK1.0
 */
public class DrSeuss {

	private static native void registerSeuss();
	static {
		registerSeuss();
	}

	/**
	 * Returns the runtime class of this {@code Object}. The returned
	 * {@code Class} object is the object that is locked by {@code
	 * static synchronized} methods of the represented class.
	 *
	 * <p><b>The actual result type is {@code Class<? extends |X|>}
	 * where {@code |X|} is the erasure of the static type of the
	 * expression on which {@code getClass} is called.</b> For
	 * example, no cast is required in this code fragment:</p>
	 *
	 * <p>
	 * {@code Number n = 0;                             }<br>
   6        * {@code Class<? extends Number> c = n.getClass(); }
   7        * </p>
   8        *
   9        * @return The {@code Class} object that represents the runtime
   0        *         class of this object.
   1        * @see    Class Literals, section 15.8.2 of
   2        *         <cite>The Java&trade; Language Specification</cite>.
   3        */
	public final native Class<?> getSeuss();

	/**
   7        * Returns a hash code value for the object. This method is
   8        * supported for the benefit of hash tables such as those provided by
   9        * {@link java.util.HashMap}.
   0        * <p>
   1        * The general contract of {@code hashCode} is:
   2        * <ul>
	 * <li>Whenever it is invoked on the same object more than once during
   4        *     an execution of a Java application, the {@code hashCode} method
   5        *     must consistently return the same integer, provided no information
   6        *     used in {@code equals} comparisons on the object is modified.
   7        *     This integer need not remain consistent from one execution of an
   8        *     application to another execution of the same application.
   9        * <li>If two objects are equal according to the {@code equals(Object)}
   0        *     method, then calling the {@code hashCode} method on each of
   1        *     the two objects must produce the same integer result.
   2        * <li>It is <em>not</em> required that if two objects are unequal
   3        *     according to the {@link java.lang.Object#equals(java.lang.Object)}
   4        *     method, then calling the {@code hashCode} method on each of the
   5        *     two objects must produce distinct integer results.  However, the
   6        *     programmer should be aware that producing distinct integer results
   7        *     for unequal objects may improve the performance of hash tables.
   8        * </ul>
   9        * <p>
   0        * As much as is reasonably practical, the hashCode method defined by
   1        * class {@code Object} does return distinct integers for distinct
   2        * objects. (This is typically implemented by converting the internal
   3        * address of the object into an integer, but this implementation
   4        * technique is not required by the
   5        * Java<font size="-2"><sup>TM</sup></font> programming language.)
   6        *
   7        * @return  a hash code value for this object.
   8        * @see     java.lang.Object#equals(java.lang.Object)
   9        * @see     java.lang.System#identityHashCode
  0        */
	public native int hashSeuss();

	/**
  4        * Indicates whether some other object is "equal to" this one.
  5        * <p>
  6        * The {@code equals} method implements an equivalence relation
  7        * on non-null object references:
  8        * <ul>
  9        * <li>It is <i>reflexive</i>: for any non-null reference value
  0        *     {@code x}, {@code x.equals(x)} should return
	 *     {@code true}.
	 * <li>It is <i>symmetric</i>: for any non-null reference values
	 *     {@code x} and {@code y}, {@code x.equals(y)}
	 *     should return {@code true} if and only if
	 *     {@code y.equals(x)} returns {@code true}.
	 * <li>It is <i>transitive</i>: for any non-null reference values
	 *     {@code x}, {@code y}, and {@code z}, if
  118        *     {@code x.equals(y)} returns {@code true} and
  119        *     {@code y.equals(z)} returns {@code true}, then
  120        *     {@code x.equals(z)} should return {@code true}.
  121        * <li>It is <i>consistent</i>: for any non-null reference values
  122        *     {@code x} and {@code y}, multiple invocations of
  123        *     {@code x.equals(y)} consistently return {@code true}
  124        *     or consistently return {@code false}, provided no
  125        *     information used in {@code equals} comparisons on the
  126        *     objects is modified.
  127        * <li>For any non-null reference value {@code x},
  128        *     {@code x.equals(null)} should return {@code false}.
  129        * </ul>
  130        * <p>
  131        * The {@code equals} method for class {@code Object} implements
  132        * the most discriminating possible equivalence relation on objects;
  133        * that is, for any non-null reference values {@code x} and
  134        * {@code y}, this method returns {@code true} if and only
  135        * if {@code x} and {@code y} refer to the same object
  136        * ({@code x == y} has the value {@code true}).
  137        * <p>
  138        * Note that it is generally necessary to override the {@code hashCode}
  139        * method whenever this method is overridden, so as to maintain the
  140        * general contract for the {@code hashCode} method, which states
  141        * that equal objects must have equal hash codes.
  142        *
  143        * @param   obj   the reference object with which to compare.
  144        * @return  {@code true} if this object is the same as the obj
  145        *          argument; {@code false} otherwise.
  146        * @see     #hashCode()
  147        * @see     java.util.HashMap
  148        */
	public boolean equalseuss(Object obj) {
		return (this == obj);
	}

	/**
  154        * Creates and returns a copy of this object.  The precise meaning
  155        * of "copy" may depend on the class of the object. The general
  156        * intent is that, for any object {@code x}, the expression:
  157        * <blockquote>
  158        * <pre>
  159        * x.clone() != x</pre></blockquote>
  160        * will be true, and that the expression:
  161        * <blockquote>
  162        * <pre>
  163        * x.clone().getClass() == x.getClass()</pre></blockquote>
  164        * will be {@code true}, but these are not absolute requirements.
  165        * While it is typically the case that:
  166        * <blockquote>
  167        * <pre>
  168        * x.clone().equals(x)</pre></blockquote>
  169        * will be {@code true}, this is not an absolute requirement.
  170        * <p>
  171        * By convention, the returned object should be obtained by calling
  172        * {@code super.clone}.  If a class and all of its superclasses (except
  173        * {@code Object}) obey this convention, it will be the case that
  174        * {@code x.clone().getClass() == x.getClass()}.
  175        * <p>
  176        * By convention, the object returned by this method should be independent
  177        * of this object (which is being cloned).  To achieve this independence,
  178        * it may be necessary to modify one or more fields of the object returned
  179        * by {@code super.clone} before returning it.  Typically, this means
  180        * copying any mutable objects that comprise the internal "deep structure"
  181        * of the object being cloned and replacing the references to these
  182        * objects with references to the copies.  If a class contains only
  183        * primitive fields or references to immutable objects, then it is usually
  184        * the case that no fields in the object returned by {@code super.clone}
  185        * need to be modified.
  186        * <p>
  187        * The method {@code clone} for class {@code Object} performs a
  188        * specific cloning operation. First, if the class of this object does
  189        * not implement the interface {@code Cloneable}, then a
  190        * {@code CloneNotSupportedException} is thrown. Note that all arrays
  191        * are considered to implement the interface {@code Cloneable} and that
  192        * the return type of the {@code clone} method of an array type {@code T[]}
  193        * is {@code T[]} where T is any reference or primitive type.
  194        * Otherwise, this method creates a new instance of the class of this
  195        * object and initializes all its fields with exactly the contents of
  196        * the corresponding fields of this object, as if by assignment; the
  197        * contents of the fields are not themselves cloned. Thus, this method
  198        * performs a "shallow copy" of this object, not a "deep copy" operation.
  199        * <p>
  200        * The class {@code Object} does not itself implement the interface
  201        * {@code Cloneable}, so calling the {@code clone} method on an object
  202        * whose class is {@code Object} will result in throwing an
  203        * exception at run time.
  204        *
  205        * @return     a clone of this instance.
  206        * @exception  CloneNotSupportedException  if the object's class does not
  207        *               support the {@code Cloneable} interface. Subclasses
  208        *               that override the {@code clone} method can also
  209        *               throw this exception to indicate that an instance cannot
  210        *               be cloned.
  211        * @see java.lang.Cloneable
  212        */
	protected native Object clonseuss() throws CloneNotSupportedException;

	/**
  216        * Returns a string representation of the object. In general, the
  217        * {@code toString} method returns a string that
  218        * "textually represents" this object. The result should
  219        * be a concise but informative representation that is easy for a
  220        * person to read.
  221        * It is recommended that all subclasses override this method.
  222        * <p>
  223        * The {@code toString} method for class {@code Object}
  224        * returns a string consisting of the name of the class of which the
  225        * object is an instance, the at-sign character `{@code @}', and
  226        * the unsigned hexadecimal representation of the hash code of the
  227        * object. In other words, this method returns a string equal to the
  228        * value of:
  229        * <blockquote>
  230        * <pre>
  231        * getClass().getName() + '@' + Integer.toHexString(hashCode())
  232        * </pre></blockquote>
  233        *
  234        * @return  a string representation of the object.
  235        */
	public String toSeuss() {
		return getClass().getName() + "@" + Integer.toHexString(hashCode());
	}

	/**
  241        * Wakes up a single thread that is waiting on this object's
  242        * monitor. If any threads are waiting on this object, one of them
  243        * is chosen to be awakened. The choice is arbitrary and occurs at
  244        * the discretion of the implementation. A thread waits on an object's
  245        * monitor by calling one of the {@code wait} methods.
  246        * <p>
  247        * The awakened thread will not be able to proceed until the current
  248        * thread relinquishes the lock on this object. The awakened thread will
  249        * compete in the usual manner with any other threads that might be
  250        * actively competing to synchronize on this object; for example, the
  251        * awakened thread enjoys no reliable privilege or disadvantage in being
  252        * the next thread to lock this object.
  253        * <p>
  254        * This method should only be called by a thread that is the owner
  255        * of this object's monitor. A thread becomes the owner of the
  256        * object's monitor in one of three ways:
  257        * <ul>
  258        * <li>By executing a synchronized instance method of that object.
  259        * <li>By executing the body of a {@code synchronized} statement
  260        *     that synchronizes on the object.
  261        * <li>For objects of type {@code Class,} by executing a
  262        *     synchronized static method of that class.
  263        * </ul>
  264        * <p>
  265        * Only one thread at a time can own an object's monitor.
  266        *
  267        * @exception  IllegalMonitorStateException  if the current thread is not
  268        *               the owner of this object's monitor.
  269        * @see        java.lang.Object#notifyAll()
  270        * @see        java.lang.Object#wait()
  271        */
	public final native void notifySeuss();

	/**
  275        * Wakes up all threads that are waiting on this object's monitor. A
  276        * thread waits on an object's monitor by calling one of the
  277        * {@code wait} methods.
  278        * <p>
  279        * The awakened threads will not be able to proceed until the current
  280        * thread relinquishes the lock on this object. The awakened threads
  281        * will compete in the usual manner with any other threads that might
  282        * be actively competing to synchronize on this object; for example,
  283        * the awakened threads enjoy no reliable privilege or disadvantage in
  284        * being the next thread to lock this object.
  285        * <p>
  286        * This method should only be called by a thread that is the owner
  287        * of this object's monitor. See the {@code notify} method for a
  288        * description of the ways in which a thread can become the owner of
  289        * a monitor.
  290        *
  291        * @exception  IllegalMonitorStateException  if the current thread is not
  292        *               the owner of this object's monitor.
  293        * @see        java.lang.Object#notify()
  294        * @see        java.lang.Object#wait()
  295        */
	public final native void notifyAllSeusses();

	/**
  299        * Causes the current thread to wait until either another thread invokes the
  300        * {@link java.lang.Object#notify()} method or the
  301        * {@link java.lang.Object#notifyAll()} method for this object, or a
  302        * specified amount of time has elapsed.
  303        * <p>
  304        * The current thread must own this object's monitor.
  305        * <p>
  306        * This method causes the current thread (call it <var>T</var>) to
  307        * place itself in the wait set for this object and then to relinquish
  308        * any and all synchronization claims on this object. Thread <var>T</var>
  309        * becomes disabled for thread scheduling purposes and lies dormant
  310        * until one of four things happens:
  311        * <ul>
  312        * <li>Some other thread invokes the {@code notify} method for this
  313        * object and thread <var>T</var> happens to be arbitrarily chosen as
  314        * the thread to be awakened.
  315        * <li>Some other thread invokes the {@code notifyAll} method for this
  316        * object.
  317        * <li>Some other thread {@linkplain Thread#interrupt() interrupts}
  318        * thread <var>T</var>.
  319        * <li>The specified amount of real time has elapsed, more or less.  If
  320        * {@code timeout} is zero, however, then real time is not taken into
  321        * consideration and the thread simply waits until notified.
  322        * </ul>
  323        * The thread <var>T</var> is then removed from the wait set for this
  324        * object and re-enabled for thread scheduling. It then competes in the
  325        * usual manner with other threads for the right to synchronize on the
  326        * object; once it has gained control of the object, all its
  327        * synchronization claims on the object are restored to the status quo
  328        * ante - that is, to the situation as of the time that the {@code wait}
  329        * method was invoked. Thread <var>T</var> then returns from the
  330        * invocation of the {@code wait} method. Thus, on return from the
  331        * {@code wait} method, the synchronization state of the object and of
  332        * thread {@code T} is exactly as it was when the {@code wait} method
  333        * was invoked.
  334        * <p>
  335        * A thread can also wake up without being notified, interrupted, or
  336        * timing out, a so-called <i>spurious wakeup</i>.  While this will rarely
  337        * occur in practice, applications must guard against it by testing for
  338        * the condition that should have caused the thread to be awakened, and
  339        * continuing to wait if the condition is not satisfied.  In other words,
  340        * waits should always occur in loops, like this one:
  341        * <pre>
  342        *     synchronized (obj) {
  343        *         while (&lt;condition does not hold&gt;)
  344        *             obj.wait(timeout);
  345        *         ... // Perform action appropriate to condition
  346        *     }
  347        * </pre>
  348        * (For more information on this topic, see Section 3.2.3 in Doug Lea's
  349        * "Concurrent Programming in Java (Second Edition)" (Addison-Wesley,
  350        * 2000), or Item 50 in Joshua Bloch's "Effective Java Programming
  351        * Language Guide" (Addison-Wesley, 2001).
  352        *
  353        * <p>If the current thread is {@linkplain java.lang.Thread#interrupt()
  354        * interrupted} by any thread before or while it is waiting, then an
  355        * {@code InterruptedException} is thrown.  This exception is not
  356        * thrown until the lock status of this object has been restored as
  357        * described above.
  358        *
  359        * <p>
  360        * Note that the {@code wait} method, as it places the current thread
  361        * into the wait set for this object, unlocks only this object; any
  362        * other objects on which the current thread may be synchronized remain
  363        * locked while the thread waits.
  364        * <p>
  365        * This method should only be called by a thread that is the owner
  366        * of this object's monitor. See the {@code notify} method for a
  367        * description of the ways in which a thread can become the owner of
  368        * a monitor.
  369        *
  370        * @param      timeout   the maximum time to wait in milliseconds.
  371        * @exception  IllegalArgumentException      if the value of timeout is
  372        *               negative.
  373        * @exception  IllegalMonitorStateException  if the current thread is not
  374        *               the owner of the object's monitor.
  375        * @exception  InterruptedException if any thread interrupted the
  376        *             current thread before or while the current thread
  377        *             was waiting for a notification.  The <i>interrupted
  378        *             status</i> of the current thread is cleared when
  379        *             this exception is thrown.
  380        * @see        java.lang.Object#notify()
  381        * @see        java.lang.Object#notifyAll()
  382        */
	public final native void waitSeuss(long timeout) throws InterruptedException;

	/**
  386        * Causes the current thread to wait until another thread invokes the
  387        * {@link java.lang.Object#notify()} method or the
  388        * {@link java.lang.Object#notifyAll()} method for this object, or
  389        * some other thread interrupts the current thread, or a certain
  390        * amount of real time has elapsed.
  391        * <p>
  392        * This method is similar to the {@code wait} method of one
  393        * argument, but it allows finer control over the amount of time to
  394        * wait for a notification before giving up. The amount of real time,
  395        * measured in nanoseconds, is given by:
  396        * <blockquote>
  397        * <pre>
  398        * 1000000*timeout+nanos</pre></blockquote>
  399        * <p>
  400        * In all other respects, this method does the same thing as the
  401        * method {@link #wait(long)} of one argument. In particular,
  402        * {@code wait(0, 0)} means the same thing as {@code wait(0)}.
  403        * <p>
  404        * The current thread must own this object's monitor. The thread
  405        * releases ownership of this monitor and waits until either of the
  406        * following two conditions has occurred:
  407        * <ul>
  408        * <li>Another thread notifies threads waiting on this object's monitor
  409        *     to wake up either through a call to the {@code notify} method
  410        *     or the {@code notifyAll} method.
  411        * <li>The timeout period, specified by {@code timeout}
  412        *     milliseconds plus {@code nanos} nanoseconds arguments, has
  413        *     elapsed.
  414        * </ul>
  415        * <p>
  416        * The thread then waits until it can re-obtain ownership of the
  417        * monitor and resumes execution.
  418        * <p>
  419        * As in the one argument version, interrupts and spurious wakeups are
  420        * possible, and this method should always be used in a loop:
  421        * <pre>
  422        *     synchronized (obj) {
  423        *         while (&lt;condition does not hold&gt;)
  424        *             obj.wait(timeout, nanos);
  425        *         ... // Perform action appropriate to condition
  426        *     }
  427        * </pre>
  428        * This method should only be called by a thread that is the owner
  429        * of this object's monitor. See the {@code notify} method for a
  430        * description of the ways in which a thread can become the owner of
  431        * a monitor.
  432        *
  433        * @param      timeout   the maximum time to wait in milliseconds.
  434        * @param      nanos      additional time, in nanoseconds range
  435        *                       0-999999.
  436        * @exception  IllegalArgumentException      if the value of timeout is
  437        *                      negative or the value of nanos is
  438        *                      not in the range 0-999999.
  439        * @exception  IllegalMonitorStateException  if the current thread is not
  440        *               the owner of this object's monitor.
  441        * @exception  InterruptedException if any thread interrupted the
  442        *             current thread before or while the current thread
  443        *             was waiting for a notification.  The <i>interrupted
  444        *             status</i> of the current thread is cleared when
  445        *             this exception is thrown.
  446        */
	public final void waitSeuss(long timeout, int nanos) throws InterruptedException {
		if (timeout < 0) {
			throw new IllegalArgumentException("timeout value is negative");
		}

		if (nanos < 0 || nanos > 999999) {
			throw new IllegalArgumentException(
					"nanosecond timeout value out of range");
		}

		if (nanos >= 500000 || (nanos != 0 && timeout == 0)) {
			timeout++;
		}

		wait(timeout);
	}

	/**
  465        * Causes the current thread to wait until another thread invokes the
  466        * {@link java.lang.Object#notify()} method or the
  467        * {@link java.lang.Object#notifyAll()} method for this object.
  468        * In other words, this method behaves exactly as if it simply
  469        * performs the call {@code wait(0)}.
  470        * <p>
  471        * The current thread must own this object's monitor. The thread
  472        * releases ownership of this monitor and waits until another thread
  473        * notifies threads waiting on this object's monitor to wake up
  474        * either through a call to the {@code notify} method or the
  475        * {@code notifyAll} method. The thread then waits until it can
  476        * re-obtain ownership of the monitor and resumes execution.
  477        * <p>
  478        * As in the one argument version, interrupts and spurious wakeups are
  479        * possible, and this method should always be used in a loop:
  480        * <pre>
  481        *     synchronized (obj) {
  482        *         while (&lt;condition does not hold&gt;)
  483        *             obj.wait();
  484        *         ... // Perform action appropriate to condition
  485        *     }
  486        * </pre>
  487        * This method should only be called by a thread that is the owner
  488        * of this object's monitor. See the {@code notify} method for a
  489        * description of the ways in which a thread can become the owner of
  490        * a monitor.
  491        *
  492        * @exception  IllegalMonitorStateException  if the current thread is not
  493        *               the owner of the object's monitor.
  494        * @exception  InterruptedException if any thread interrupted the
  495        *             current thread before or while the current thread
  496        *             was waiting for a notification.  The <i>interrupted
  497        *             status</i> of the current thread is cleared when
  498        *             this exception is thrown.
  499        * @see        java.lang.Object#notify()
  500        * @see        java.lang.Object#notifyAll()
  501        */
	public final void waitSeuss() throws InterruptedException {
		wait(0);
	}

	/**
  507        * Called by the garbage collector on an object when garbage collection
  508        * determines that there are no more references to the object.
  509        * A subclass overrides the {@code finalize} method to dispose of
  510        * system resources or to perform other cleanup.
  511        * <p>
  512        * The general contract of {@code finalize} is that it is invoked
  513        * if and when the Java<font size="-2"><sup>TM</sup></font> virtual
  514        * machine has determined that there is no longer any
  515        * means by which this object can be accessed by any thread that has
  516        * not yet died, except as a result of an action taken by the
  517        * finalization of some other object or class which is ready to be
  518        * finalized. The {@code finalize} method may take any action, including
  519        * making this object available again to other threads; the usual purpose
  520        * of {@code finalize}, however, is to perform cleanup actions before
  521        * the object is irrevocably discarded. For example, the finalize method
  522        * for an object that represents an input/output connection might perform
  523        * explicit I/O transactions to break the connection before the object is
  524        * permanently discarded.
  525        * <p>
  526        * The {@code finalize} method of class {@code Object} performs no
  527        * special action; it simply returns normally. Subclasses of
  528        * {@code Object} may override this definition.
  529        * <p>
  530        * The Java programming language does not guarantee which thread will
  531        * invoke the {@code finalize} method for any given object. It is
  532        * guaranteed, however, that the thread that invokes finalize will not
  533        * be holding any user-visible synchronization locks when finalize is
  534        * invoked. If an uncaught exception is thrown by the finalize method,
  535        * the exception is ignored and finalization of that object terminates.
  536        * <p>
  537        * After the {@code finalize} method has been invoked for an object, no
  538        * further action is taken until the Java virtual machine has again
  539        * determined that there is no longer any means by which this object can
  540        * be accessed by any thread that has not yet died, including possible
  541        * actions by other objects or classes which are ready to be finalized,
  542        * at which point the object may be discarded.
  543        * <p>
  544        * The {@code finalize} method is never invoked more than once by a Java
  545        * virtual machine for any given object.
  546        * <p>
  547        * Any exception thrown by the {@code finalize} method causes
  548        * the finalization of this object to be halted, but is otherwise
  549        * ignored.
  550        *
  551        * @throws Throwable the {@code Exception} raised by this method
  552        */
	protected void finalizeSeuss() throws Throwable { }
}