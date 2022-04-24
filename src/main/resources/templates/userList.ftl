<#import "parts/common.ftl" as c>
<@c.page>
    <h3>Список пользователей</h3>
    <table class="table table__list">
        <thead>
        <tr>
<#--            <th scope="col">#</th>-->
            <th scope="col">Имя</th>
            <th scope="col">Роль</th>
            <th scope="col"></th>
            <th scope="col"></th>
        </tr>
        </thead>
        <tbody class="tbody_white text-black">
        <#list users as user>
            <tr>
<#--                <td>${user.id}</td>-->
                <td>${user.username}</td>
                <td><#list user.roles as role>${role}<#sep>, </#list></td>
                <td>
                    <a class="btn btn-outline-primary"
                       href="/user/${user.id}">Редактировать</a>
                </td>
                <td>
                    <a class="btn btn-outline-danger"
                       href="/user-del">Удалить</a>
                </td>
            </tr>
        </#list>
        </tbody>
    </table>
    <button class="btn btn-secondary m-2" href="#" onclick="history.back();return false;">Назад</button>

</@c.page>