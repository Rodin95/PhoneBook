<#include "security.ftl">
<#import "login.ftl" as l>


<#macro navbar>

    <nav class="navbar navbar-expand-lg navbar-light rounded rounded-3">
        <div class="container-fluid">
            <a href="/">
                <img src="/static/img/logo.png" alt="" width="" height="100"
                     class="navbar-brand m-0">
            </a>
            <h3 class="logoTextGlow"><span>А</span><span>О</span><span>«</span><span>Э</span><span>Л</span><span>E</span><span>К</span><span>Т</span><span>Р</span><span>О</span><span>С</span><span>И</span><span>Г</span><span>Н</span><span>А</span><span>Л</span><span>»</span></h3>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">

                </ul>
                <#if name !="unknown">
                    <div class="btn-group m-3">
                        <button type="button" class="btn btn-outline-danger">${name}</button>
                        <button type="button"
                                class="btn btn-outline-danger dropdown-toggle dropdown-toggle-split"
                                data-bs-toggle="dropdown" aria-expanded="false">
                        </button>
                        <ul class="dropdown-menu" aria-labelledby="navbarSupportedContent">

                            <#if isAdmin>
                                <li>
                                    <a class="dropdown-item" href="/user">Список пользователей</a>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="/registration">Добавить пользователя</a>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="/people">Актуализировать базу справочника</a>
                                </li>
                            </#if>

                            <#if user??>
                                <li>
                                    <a class="dropdown-item" href="/user/profile">Профиль</a>
                                </li>
                                <li>
                                    <a class="dropdown-item" href="/user-persons/${currentUserId}">Добавленные
                                        номера пользователем: ${name}</a>
                                </li>
                            </#if>
                            <li>
                                <hr class="dropdown-divider">
                            </li>
                            <li class="m-2">
                                <#if name !="unknown"><@l.logout/></#if>
                            </li>
                        </ul>
                    </div>
                </#if>

                <form method="get" action="/phoneBook" class="d-flex" >
                    <input type="text" name="filter" class="form-control shadow-blue radius_left form-filter" placeholder="Поиск" style="z-index: 3;"
                           value="${filter?if_exists}" />
                    <button type="submit" class="btn btn-primary text-light shadow-blue radius_right">Найти</button>
                </form>

            </div>
        </div>
    </nav>
</#macro>