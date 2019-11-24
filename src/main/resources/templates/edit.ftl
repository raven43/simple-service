<#import "common.ftl" as common>

<@common.page "Edit" "edit">
    <form method="post" class="m-2 needs-validation" enctype="multipart/form-data" novalidate>
        <div class="form-group">
            <label for="name">Service Name</label>
            <input name="name" id="name" placeholder="Service name..." class="form-control" type="text" maxlength="128"
                    <#if service?? && service.name??>value="${service.name}"</#if> required>
        </div>
        <div class="form-group">
            <label for="device">Device Type</label>
            <select name="device" id="device" class="form-control" required>
                <option value="" disabled>Select Type...</option>
                <#list devices as device>
                    <option value="${device.name()}">${device.getDisplayName()}</option>
                </#list>
            </select>
        </div>
        <div class="form-group">
            <label for="producer">Device Producer</label>
            <input name="producer" id="producer" placeholder="Device Producer..." type="text" class="form-control"
                   maxlength="128" required
                   <#if service?? && service.producer??>value="${service.producer}"</#if>>
        </div>
        <div class="form-group">
            <label for="model">Device Model</label>
            <input name="model" id="model" placeholder="Device Model..." type="text" class="form-control"
                   maxlength="128" required
                   <#if service?? && service.model??>value="${service.model}"</#if>>
        </div>
        <div class="form-group">
            <label for="type">Service Type</label>
            <input name="type" id="type" type="text" placeholder="Service Type..." class="form-control" maxlength="128"
                   required <#if service?? && service.type??>value="${service.type}"</#if>>
        </div>
        <div class="form-group">
            <label for="termDays">Term (Days)</label>
            <input name="termDays" id="termDays" type="number" class="form-control" min="0" required
                   <#if service?? && service.termDays??>value="${service.termDays}"</#if>>
        </div>
        <div class="form-group">
            <label>Cost (BYN)</label>
            <input name="cost" id="cost" type="number" class="form-control" min="0" required
                   <#if service?? && service.cost??>value="${service.cost}"</#if>>
        </div>
        <div class="form-group">
            <label>Image URL (Optional)</label>
            <input type="url" name="imageUrl" id="imageUrl" class="form-control" maxlength="1024"
                   <#if service?? && service.imageUrl??>value="${service.imageUrl}"</#if>>
        </div>
        <div class="form-group">
            <button type="submit" class="btn btn-primary">Submit</button>
        </div>
    </form>
</@common.page>