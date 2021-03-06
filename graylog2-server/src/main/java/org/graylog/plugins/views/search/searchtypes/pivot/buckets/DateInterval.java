/**
 * This file is part of Graylog.
 *
 * Graylog is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.graylog.plugins.views.search.searchtypes.pivot.buckets;

public class DateInterval {
    private final Number quantity;
    private final String unit;

    public DateInterval(Number quantity, String unit) {
        this.quantity = quantity;
        this.unit = unit;
    }

    public static DateInterval seconds(int sec) {
        return new DateInterval(sec, "s");
    }

    public static DateInterval minutes(int min) {
        return new DateInterval(min, "m");
    }

    public static DateInterval hours(int hours) {
        return new DateInterval(hours, "h");
    }

    public static DateInterval days(int days) {
        return new DateInterval(days, "d");
    }

    public static DateInterval weeks(int weeks) {
        return new DateInterval(weeks, "w");
    }

    public static DateInterval months(int months) {
        return new DateInterval(months, "M");
    }

    public Number getQuantity() {
        return quantity;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public String toString() {
        return quantity + unit;
    }
}
