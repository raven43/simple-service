<#import "common.ftl" as common>

<@common.page item.name>

    <div class="row m-0 pt-3">
        <div class="col-auto">
            <#if item.imageUrl?? && item.imageUrl?has_content>
                <img src="${item.imageUrl}" class="icon-lg">
            <#else >
                <img src="/static/default.png" class="icon-lg">
            </#if>
        </div>
        <div class="col">
            <div class="card">
                <div class="card-header py-2 d-flex justify-content-between">
                    <h4 class="card-title m-0">${item.name}</h4>
                    <div class="btn-group">
                        <form method="get" action="/edit/${item.id}">
                            <button type="submit" class="btn btn-info">Edit</button>
                        </form>
                        <form method="post" action="/service/${item.id}/delete">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </div>
                </div>
                <div class="card-body">
                    <table class="table table-striped table-bordered table-hover table">
                        <tbody>
                            <tr>
                                <td>Service Name</td>
                                <td>${item.name}</td>
                            </tr>
                            <tr>
                                <td>Device</td>
                                <td>${item.device.getDisplayName()}</td>
                            </tr>
                            <tr>
                                <td>Device Producer</td>
                                <td>${item.producer}</td>
                            </tr>
                            <tr>
                                <td>Device Model</td>
                                <td>${item.model}</td>
                            </tr>
                            <tr>
                                <td>Service Type</td>
                                <td>${item.type}</td>
                            </tr>
                            <tr>
                                <td>Term (Days)</td>
                                <td>${item.termDays}</td>
                            </tr>
                            <tr>
                                <td>Cost (BYN)</td>
                                <td>${item.cost}</td>
                            </tr>
                        </tbody>
                    </table>

                </div>
            </div>
        </div>
    </div>


</@common.page>