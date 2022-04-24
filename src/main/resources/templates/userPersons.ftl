<#import "parts/common.ftl" as c>
<#include "parts/security.ftl">

<@c.page>
    <#if isCurrentUser || isAdmin>
        <#include "parts/personEdit.ftl" />
    </#if>

</@c.page>
