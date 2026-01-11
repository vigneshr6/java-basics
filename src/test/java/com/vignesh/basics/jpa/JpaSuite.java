package com.vignesh.basics.jpa;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({
        EntityManagerTest.class,
        RepositoryTest.class
})
public class JpaSuite {
}
