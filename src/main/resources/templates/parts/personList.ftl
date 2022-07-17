<#include "security.ftl">
<#import "pager.ftl" as p>

<div class="container-table mt-5 shadow p-3 mb-5 bg-light radius_all "
     style="z-index: 2000;">
    <h3 class="text">Телефонный справочник</h3>
    <@p.pager url page />

    <div class="container__table table-responsive">
        <table class="table table__list" style="">
            <thead>
            <tr>
                <#--            <th class="tableCursor" scope="col">№</th>-->
<#--                <#if name!="unknown">-->
<#--                <th class="head_table m1" scope="col">Id</th>-->
<#--                </#if>-->
                <th class="head_table m1" scope="col">Фамилия</th>
                <th class="head_table" scope="col">Имя</th>
                <th class="head_table" scope="col">Отчество</th>
                <th class="head_table" scope="col">Отдел цех</th>
                <th class="head_table" scope="col">Должность</th>
                <th class="head_table" scope="col">Номер телефона</th>
                <th class="head_table" scope="col">Наименование подразделения</th>
                <#if name!="unknown">
                    <th class="head_table" scope="col">Пользователь</th>
                </#if>
                <#if name!="unknown">
                    <th class="head_table_button" scope="col"></th>
                    <th class="head_table_button" scope="col"></th>
                    <th class="head_table_button m2" scope="col"></th>
                <#else>
                    <th class="head_table_button m2" scope="col"></th>
                </#if>
            </tr>
            </thead>
            <tbody class="tbody_white text-black">

            <#list page.content as person>
                <tr>
<#--                    <#if name!="unknown">-->
<#--                        <td>${person.id}</td>-->
<#--                    </#if>-->
                    <td>${person.secondName}</td>
                    <td>${person.firstName}</td>
                    <td>${person.thirdName}</td>
                    <td>${person.department}</td>
                    <td>${person.position}</td>
                    <td>${person.phoneNumber}</td>
                    <td>${person.location}</td>
                    <#if name!="unknown">
                        <td>
                            <a>${person.authorName}</a>
                        </td>
                    </#if>
                    <td>
                        <#if person.filename??>
                            <button type="button" class="btn btn-outline-secondary ms-3 shadow-sm"
                                    data-bs-toggle="offcanvas"
                                    data-bs-target="#offcanvasScrolling${person.id}"
                                    aria-controls="offcanvasScrolling">Подробнее
                            </button>
                            <div class="offcanvas offcanvas-start align-content-center text-center text-black"
                                 data-bs-scroll="true"
                                 data-bs-backdrop="true"
                                 tabindex="-1" id="offcanvasScrolling${person.id}"
                                 aria-labelledby="offcanvasScrollingLabel">
                                <div class="offcanvas-header text-center">
                                    <h5 class="offcanvas-title"
                                        id="offcanvasScrollingLabel">Информация</h5>
                                    <button type="button" class="btn-close text-reset"
                                            data-bs-dismiss="offcanvas"
                                            aria-label="Close"></button>
                                </div>
                                <div class="offcanvas-body align-content-center">
                                    <p>${person.secondName} ${person.firstName} ${person.thirdName}</p>
                                    <img src="/img/${person.filename}"
                                         class="rounded img-fluid"
                                         alt="${person.secondName} ${person.firstName} ${person.thirdName}"
                                         title="${person.secondName} ${person.firstName} ${person.thirdName}"
                                         width="350" height="650"/>
                                    <br>
                                    <p class="padding-25px">${person.position}</p>
                                </div>
                            </div>
                        </#if>
                    </td>
                    <#if name!="unknown">
                        <#if person.author.id == currentUserId || isAdmin>
                            <td>
                                <a class="btn btn-outline-primary"
                                   href="/user-persons/${person.author.id}?person=${person.id?c}">Редактировать</a>
                            </td>
                            <td>
                                <a class="btn btn-outline-danger"
                                   href="/del-user-persons/${person.author.id}?person=${person.id?c}">Удалить</a>
                            </td>
                        </#if>
                    </#if>
                </tr>
            <#else>
                <#if !person?has_content>
                    <#if name="unknown">
                        <div class="modal-body">
                            <p class="mt-5">По вашему запросу не найдено записей! <a href="#" role="button"
                                                                                     class="btn btn-secondary popover-test"
                                                                                     title=""
                                                                                     data-bs-content="Popover body content is set in this attribute.">Справка</a>нажмите
                                на кнопку для помощи в поиске в справочнике</p>
                        </div>
                    <#--                        <div class="modal-body">-->
                    <#--                            <h5> Нет записей в базе данных! </h5>-->
                    <#--                            <p>Авторизуйтесь под администратором и заполните справочник <a href="/login" role="button" class="btn btn-secondary popover-test" title="" data-bs-content="Popover body content is set in this attribute.">Авторизация</a>нажмите на кнопку для авторизации</p>-->
                    <#--                        </div>-->
                    <#else>
                        <div class="modal-body">
                            <h5> Нет записей в базе данных! </h5>
                        </div>
                    </#if>
                </#if>
            </#list>
            </tbody>
            <script>
                document.addEventListener('DOMContentLoaded', () => {

                    const getSort = ({target}) => {
                        const order = (target.dataset.order = -(target.dataset.order || -1));
                        const index = [...target.parentNode.cells].indexOf(target);
                        const collator = new Intl.Collator(['en', 'ru'], {numeric: true});
                        const comparator = (index, order) => (a, b) => order * collator.compare(
                            a.children[index].innerHTML,
                            b.children[index].innerHTML
                        );

                        for (const tBody of target.closest('table').tBodies)
                            tBody.append(...[...tBody.rows].sort(comparator(index, order)));

                        for (const cell of target.parentNode.cells)
                            cell.classList.toggle('sorted', cell === target);
                    };

                    document.querySelectorAll('.table thead').forEach(tableTH => tableTH.addEventListener('click', () => getSort(event)));

                });
            </script>
        </table>
    </div>
    <@p.pager url page />
</div>
