package com.uspeclipse.parameterization;

import org.junit.rules.TestRule;

public interface Generator<T> extends TestRule {
	public T value();
}
