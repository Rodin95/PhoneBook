<#include "security.ftl">
<#macro login path isRegisterForm>

    <form action="${path}" method="post" class="row">
        <div class="login">
            <div>
                <label class="col-form-label"> Имя пользователя</label>
                <input type="text" name="username" class="form-control ${(usernameError??)?string('is-invalid', '')}"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <#if usernameError??>
                    <div class="invalid-feedback">
                        ${usernameError}
                    </div>
                </#if>
            </div>
            <div>
                <label class="col-form-label">Пароль</label>
                <input type="password" name="password" class="form-control ${(passwordError??)?string('is-invalid', '')}"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                <#if passwordError??>
                    <div class="invalid-feedback">
                        ${passwordError}
                    </div>
                </#if>
            </div>
        </div>
        <div class="mt-3">
            <button class="btn btn-outline-primary text-light m-2" type="submit"><#if isRegisterForm>Создать<#else>Войти</#if></button>
            <a class="btn btn-outline-info m-2 text-light" href="/phoneBook">Телефонный справочник</a>
            <button class="btn btn-outline-secondary m-2" href="#" onclick="history.back();return false;">Назад</button>
        </div>

    </form>

</#macro>

<#macro logout>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <input type="submit" class="btn btn-outline-danger" value="Выйти"/>
    </form>
</#macro>