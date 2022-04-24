
<#if name!="unknown">
    <div class="accordion" id="accordionExample">
        <div class="accordion-item">
            <h2 class="accordion-header" id="headingOne">
                <button class="accordion-button" type="button" data-bs-toggle="collapse"
                        data-bs-target="#collapseOne"
                        aria-expanded="true" aria-controls="collapseOne">
                    Добавить запись
                </button>
            </h2>
            <div id="collapseOne" class="accordion-collapse collapse <#if person??>show</#if>"
                 aria-labelledby="headingOne" data-bs-parent="#accordionExample">
                <div class="accordion-body">
                    <form method="post" enctype="multipart/form-data">
                        <div class="form-group">
                            <input type="text"
                                   class="form-control m-2 ${(secondNameError??)?string('is-invalid', '')}"
                                   value="<#if person??>${person.secondName}</#if>"
                                   name="secondName"
                                   placeholder="Введите Фамилию"/>
                            <#if secondNameError??>
                                <div class="invalid-feedback">
                                    ${secondNameError}
                                </div>
                            </#if>
                        </div>

                        <div class="form-group">
                            <input type="text"
                                   class="form-control m-2 ${(firstNameError??)?string('is-invalid', '')}"
                                   name="firstName"
                                   value="<#if person??>${person.firstName}</#if>" placeholder="Введите Имя"/>
                            <#if firstNameError??>
                                <div class="invalid-feedback">
                                    ${firstNameError}
                                </div>
                            </#if>
                        </div>

                        <div class="form-group">
                            <input type="text"
                                   class="form-control m-2 ${(thirdNameError??)?string('is-invalid', '')}"
                                   name="thirdName"
                                   value="<#if person??>${person.thirdName}</#if>" placeholder="Введите Отчество"/>
                            <#if thirdNameError??>
                                <div class="invalid-feedback">
                                    ${thirdNameError}
                                </div>
                            </#if>
                        </div>

                        <div class="form-group">
                            <input type="text"
                                   class="form-control m-2 ${(departmentError??)?string('is-invalid', '')}"
                                   name="department"
                                   value="<#if person??>${person.department}</#if>" placeholder="Введите Отдел"/>
                            <#if departmentError??>
                                <div class="invalid-feedback">
                                    ${departmentError}
                                </div>
                            </#if>
                        </div>

                        <div class="form-group">
                            <input type="text"
                                   class="form-control m-2 ${(positionError??)?string('is-invalid', '')}"
                                   name="position"
                                   value="<#if person??>${person.position}</#if>" placeholder="Введите Должность"/>
                            <#if positionError??>
                                <div class="invalid-feedback">
                                    ${positionError}
                                </div>
                            </#if>
                        </div>

                        <div class="form-group">
                            <input type="tel"
                                   class="form-control m-2 ${(phoneNumberError??)?string('is-invalid', '')}"
                                   name="phoneNumber"
                                   value="<#if person??>${person.phoneNumber}</#if>"
                                   placeholder="Введите номер телефона"/>
                            <#if phoneNumberError??>
                                <div class="invalid-feedback">
                                    ${phoneNumberError}
                                </div>
                            </#if>
                        </div>

                        <div class="form-group">
                            <input type="text"
                                   class="form-control m-2 ${(locationError??)?string('is-invalid', '')}"
                                   name="location"
                                   value="<#if person??>${person.location}</#if>"
                                   placeholder="Введите наименование подразделения"/>
                            <#if locationError??>
                                <div class="invalid-feedback">
                                    ${locationError}
                                </div>
                            </#if>
                        </div>
                        <div class="form-group">

                            <input type="file" class="form-control m-2" name="file" id="customFile"/>
                            <label for="customFile">Выбрать фотографию</label>

                        </div>

                        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                        <div class="form-group">
                            <button type="submit" class="btn btn-outline-success m-2">Добавить</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</#if>