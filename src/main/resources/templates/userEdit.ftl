<#import "parts/common.ftl" as c>

<@c.page>
   Редактировать пользователя

   <form action="/user" method="post">
       <input type="text" name="username" value="${user.username}" />
        <#list roles as role>
            <div>
                <label><input type="checkbox" name="${role}" ${user.roles?seq_contains(role)?string("checked", "")}/>${role}</label>
            </div>
        </#list>

       <input type="hidden" name="userId" value="${user.id}" />
       <input type="hidden" value="${_csrf.token}" name="_csrf"/>
       <button class="btn btn-secondary m-2" href="#" onclick="history.back();return false;">Назад</button>
       <button type="submit" class="btn btn-secondary">Сохранить</button>
   </form>
</@c.page>