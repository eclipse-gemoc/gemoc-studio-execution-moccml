/**
 */
package org.eclipse.gemoc.example.moccmlsigpml.model.sigpml;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Agent State</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see org.eclipse.gemoc.example.moccmlsigpml.model.sigpml.SigpmlPackage#getAgentState()
 * @model
 * @generated
 */
public enum AgentState implements Enumerator {
	/**
	 * The '<em><b>Instantiated</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTANTIATED_VALUE
	 * @generated
	 * @ordered
	 */
	INSTANTIATED(0, "instantiated", "instantiated"),

	/**
	 * The '<em><b>Reading Inputs</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #READING_INPUTS_VALUE
	 * @generated
	 * @ordered
	 */
	READING_INPUTS(1, "readingInputs", "readingInputs"),

	/**
	 * The '<em><b>Executing</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXECUTING_VALUE
	 * @generated
	 * @ordered
	 */
	EXECUTING(2, "executing", "executing"),

	/**
	 * The '<em><b>Writing Outputs</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WRITING_OUTPUTS_VALUE
	 * @generated
	 * @ordered
	 */
	WRITING_OUTPUTS(3, "writingOutputs", "writingOutputs");

	/**
	 * The '<em><b>Instantiated</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #INSTANTIATED
	 * @model name="instantiated"
	 * @generated
	 * @ordered
	 */
	public static final int INSTANTIATED_VALUE = 0;

	/**
	 * The '<em><b>Reading Inputs</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #READING_INPUTS
	 * @model name="readingInputs"
	 * @generated
	 * @ordered
	 */
	public static final int READING_INPUTS_VALUE = 1;

	/**
	 * The '<em><b>Executing</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #EXECUTING
	 * @model name="executing"
	 * @generated
	 * @ordered
	 */
	public static final int EXECUTING_VALUE = 2;

	/**
	 * The '<em><b>Writing Outputs</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WRITING_OUTPUTS
	 * @model name="writingOutputs"
	 * @generated
	 * @ordered
	 */
	public static final int WRITING_OUTPUTS_VALUE = 3;

	/**
	 * An array of all the '<em><b>Agent State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final AgentState[] VALUES_ARRAY =
		new AgentState[] {
			INSTANTIATED,
			READING_INPUTS,
			EXECUTING,
			WRITING_OUTPUTS,
		};

	/**
	 * A public read-only list of all the '<em><b>Agent State</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<AgentState> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Agent State</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AgentState get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AgentState result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Agent State</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AgentState getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			AgentState result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Agent State</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static AgentState get(int value) {
		switch (value) {
			case INSTANTIATED_VALUE: return INSTANTIATED;
			case READING_INPUTS_VALUE: return READING_INPUTS;
			case EXECUTING_VALUE: return EXECUTING;
			case WRITING_OUTPUTS_VALUE: return WRITING_OUTPUTS;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private AgentState(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //AgentState
