/**
 * Copyright 2013 Lennart Koopmann <lennart@torch.sh>
 *
 * This file is part of Graylog2.
 *
 * Graylog2 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Graylog2 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Graylog2.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package models;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import lib.APIException;
import lib.ApiClient;
import models.api.requests.dashboards.CreateDashboardRequest;
import models.api.responses.dashboards.DashboardSummaryResponse;
import models.api.responses.dashboards.GetDashboardsResponse;
import play.mvc.Http;

import java.io.IOException;
import java.util.List;

/**
 * @author Lennart Koopmann <lennart@torch.sh>
 */
public class DashboardService {

    private final ApiClient api;

    @Inject
    private DashboardService(ApiClient api) {
        this.api = api;
    }

    public List<Dashboard> getAll() throws APIException, IOException {
        List<Dashboard> dashboards = Lists.newArrayList();
        GetDashboardsResponse response = api.get(GetDashboardsResponse.class).path("/dashboards").execute();

        if (response == null || response.dashboards == null) {
            return dashboards;
        }

        for(DashboardSummaryResponse dr : response.dashboards) {
            dashboards.add(new Dashboard(dr));
        }

        return dashboards;
    }

    public void create(CreateDashboardRequest request) throws APIException, IOException {
        api.post().path("/dashboards").body(request).expect(Http.Status.CREATED).execute();
    }

}
