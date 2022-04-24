 <#import "parts/common.ftl" as c>
 <#import "parts/login.ftl" as l>
 <@c.page>
     <#if RequestParameters.error??>
         <div class="mb-3 alert alert-danger"
              role="alert">
             ${Session.SPRING_SECURITY_LAST_EXCEPTION.message}
         </div>
     </#if>
     <#if person??>
         <div class="alert alert-${personType}" role="alert">
             ${person}
         </div>
     </#if>
     <@l.login "/login" false/>
 </@c.page>