/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.skife.jdbi.v2.util;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultColumnMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public enum LongColumnMapper implements ResultColumnMapper<Long> {
    PRIMITIVE(false),
    WRAPPER(true);

    private final boolean nullable;

    LongColumnMapper(boolean nullable) {
        this.nullable = nullable;
    }

    @Override
    public Long mapColumn(ResultSet r, int columnNumber, StatementContext ctx) throws SQLException {
        long value = r.getLong(columnNumber);
        return nullable && r.wasNull() ? null : value;
    }

    @Override
    public Long mapColumn(ResultSet r, String columnLabel, StatementContext ctx) throws SQLException {
        long value = r.getLong(columnLabel);
        return nullable && r.wasNull() ? null : value;
    }
}
