<#import "parts/common.ftl" as c>
<#import "parts/footer.ftl" as f>
<#include "parts/security.ftl">
<@c.page>
    <h5>${username}</h5>
    ${person?ifExists}
    <form method="post" class="row">
        <div class="login">
            <label class="col-form-label">Пароль</label>
            <input type="password" name="password" class="form-control"/>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        </div>
        <div class="mt-3">
            <button class="btn btn-outline-info m-2 text-light" type="submit">Сохранить</button>
            <button class="btn btn-outline-secondary m-2 text-light" href="#" onclick="history.back();return false;">Назад</button>
        </div>
    </form>
</@c.page>