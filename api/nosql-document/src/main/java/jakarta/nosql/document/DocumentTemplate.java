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
package jakarta.nosql.document;


import jakarta.nosql.PreparedStatement;
import jakarta.nosql.Template;

import java.util.Optional;
import java.util.stream.Stream;

/**
 * {@link Template} specialization for Document-oriented databases.
 *
 * <p>
 * These databases store data as documents, individual data sets that can be grouped into collections.
 *
 * <p>
 * This interface provides some methods that accepts queries in a text format to retrieve from the database but, <b>the query syntax belongs to each provider, thus, it is not Jakarta's NoSQL scope to define it. Accordingly, it might vary from implementation and NoSQL provider.</b>
 */
public interface DocumentTemplate extends Template {


    /**
     * Returns the number of elements from document collection
     *
     * @param documentCollection the document collection
     * @return the number of elements
     * @throws NullPointerException          when document collection is null
     * @throws UnsupportedOperationException when the database dot not have support
     */
    long count(String documentCollection);

    /**
     * Returns the number of elements from document collection
     *
     * @param <T>        entityType
     * @param entityType the document collection
     * @return the number of elements
     * @throws NullPointerException          when document collection is null
     * @throws UnsupportedOperationException when the database dot not have support
     */
    <T> long count(Class<T> entityType);


    /**
     * Executes a query database, then bring the result as a {@link Stream}
     *
     * <p>
     * <b>The query syntax belongs to each provider, thus, it is not Jakarta's NoSQL scope to define it. Accordingly, it might vary from implementation and NoSQL provider.</b>
     *
     * @param query the query
     * @param <T>   the entity type
     * @return the result as {@link Stream}
     * @throws NullPointerException          when the query is null
     * @throws UnsupportedOperationException when the provider does not support query by text
     */
    <T> Stream<T> query(String query);

    /**
     * Executes a query database, then bring the result as a unique result
     *
     * <p>
     * <b>The query syntax belongs to each provider, thus, it is not Jakarta's NoSQL scope to define it. Accordingly, it might vary from implementation and NoSQL provider.</b>
     *
     * @param query the query
     * @param <T>   the entity type
     * @return the result as {@link Optional}
     * @throws NullPointerException          when the query is null
     * @throws UnsupportedOperationException when the provider does not support query by text
     */
    <T> Optional<T> singleResult(String query);

    /**
     * Creates a {@link PreparedStatement} from the query
     *
     * <p>
     * <b>The query syntax belongs to each provider, thus, it is not Jakarta's NoSQL scope to define it. Accordingly, it might vary from implementation and NoSQL provider.</b>
     *
     * @param query the query
     * @return a {@link PreparedStatement} instance
     * @throws NullPointerException          when the query is null
     * @throws UnsupportedOperationException when the provider does not support query by text
     */
    PreparedStatement prepare(String query);

}
