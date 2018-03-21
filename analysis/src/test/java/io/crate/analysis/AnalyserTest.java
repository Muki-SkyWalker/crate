/*
 * Licensed to Crate under one or more contributor license agreements.
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.  Crate licenses this file
 * to you under the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.  You may
 * obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or
 * implied.  See the License for the specific language governing
 * permissions and limitations under the License.
 *
 * However, if you have executed another commercial license agreement
 * with Crate these terms will supersede the license and you may use the
 * software solely pursuant to the terms of the relevant commercial
 * agreement.
 */

package io.crate.analysis;


import io.crate.analysis.tree.AnalysedStatement;
import io.crate.analysis.tree.AnalysedTable;
import io.crate.analysis.tree.TypedExpression;
import io.crate.sql.parser.SqlParser;
import org.junit.Test;

import static java.util.Collections.singletonMap;

public class AnalyserTest {

    @Test
    public void testFoo() {
        AnalysedStatement statement = Analyser.analyse(
            new MetaData(
                new Schemas(singletonMap(
                    "doc",
                    new Schema(singletonMap(
                        "t1",
                        new AnalysedTable(singletonMap("x", new TypedExpression())))
                    )
                ))
            ),
            new Session(),
            SqlParser.createStatement("select x from t1"));
        System.out.println(statement);
    }
}
