<#import "parts/common.ftl" as c>
<#import "parts/navbar.ftl" as n>
<#import "parts/footer.ftl" as f>
<#include "parts/security.ftl">
<@c.page>

    <@n.navbar/>

    <#include "parts/personAdd.ftl">

    <#include "parts/personList.ftl">

    <@f.footer/>

</@c.page>
