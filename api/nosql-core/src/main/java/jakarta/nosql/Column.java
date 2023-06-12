/*
 * Copyright (c) 2022 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the Eclipse
 * Public License v. 2.0 are satisfied: GNU General Public License, version 2
 * with the GNU Classpath Exception which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */
package jakarta.nosql;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Specify the mapped column for a persistent property or field.
 *
 * @see Entity
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.PARAMETER})
public @interface Column {
    /**
     * (Optional) The name of the column. Defaults to the property or field name.
     *
     * <p>
     * The sample below shows the {@code Person} entity where the mapped fields with {@code @Column} will be going be mapped to columns with their respective field name:
     *
     * <pre>{@code
     * @Entity
     * public class Person {
     *
     *     @Column
     *     private String name;
     *
     * }
     * }</pre>
     * <p>
     * If any name customization is needed, it just set the single attribute of the annotation to specify the desired name.
     * In the sample below the Person name field will be mapped to the "personName" column:
     *
     * <pre>{@code
     * @Entity
     * public class Person {
     *
     *     @Column("personName")
     *     private String name;
     *
     * }
     * }</pre>
     *
     * @return the column name
     */
    String value() default "";
}
