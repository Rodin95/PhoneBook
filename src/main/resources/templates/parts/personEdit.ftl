<form method="post" enctype="multipart/form-data">
    <div class="container">
        <div class="row p-1">
            <div class="col justify-content-end">
                <label for="secondName" class="col-form-label">Фамилия</label>
            </div>
            <div class="col justify-content-center">
                <input type="text" class="form-control" id="floatingInput" name="secondName"
                       placeholder="Введите Фамилию" value="${person.secondName}"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
            <div class="col justify-content-start">
                Введите фамилию пользователя
            </div>
        </div>
        <div class="row p-1 ">
            <div class="col">
                <label for="firstName" class="col-form-label">Имя</label>
            </div>
            <div class="col">
                <input type="text" class="form-control" id="floatingInput" name="firstName"
                       placeholder="Введите Имя" value="${person.firstName}"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
            <div class="col">
                Введите имя пользователя
            </div>
        </div>
        <div class="row p-1 ">
            <div class="col">
                <label for="thirdName" class="col-form-label">Отчество</label>
            </div>
            <div class="col">
                <input type="text" class="form-control" id="floatingInput" name="thirdName"
                       placeholder="Введите Отчество" value="${person.thirdName}"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
            <div class="col">
                Введите отчество пользователя
            </div>
        </div>
        <div class="row p-1 ">
            <div class="col">
                <label for="thirdName" class="col-form-label">Отдел</label>
            </div>
            <div class="col">
                <input type="text" class="form-control" id="floatingInput" name="department"
                       placeholder="Введите Отдел" value="${person.department}"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
            <div class="col">
                Введите отдел к которому относится пользователь
            </div>
        </div>
        <div class="row p-1 ">
            <div class="col">
                <label for="position" class="col-form-label">Должность</label>
            </div>
            <div class="col">
                <input type="text" class="form-control" id="floatingInput" name="position"
                       placeholder="Введите Должность" value="${person.position}"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
            <div class="col">
                Введите должность пользователя
            </div>
        </div>
        <div class="row p-1 ">
            <div class="col">
                <label for="phoneNumber" class="col-form-label">Номер телефона</label>
            </div>
            <div class="col">
                <input type="tel" class="form-control" name="phoneNumber"
                       placeholder="Введите номер телефона" value="${person.phoneNumber}"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
            <div class="col">
                Введите номер телефона используя правило: (XX-XX)
            </div>
        </div>
        <div class="row p-1 ">
            <div class="col">
                <label for="location" class="col-form-label">Наименование подразделения</label>
            </div>
            <div class="col">
                <input type="tel" class="form-control" name="location"
                       placeholder="Введите наименование подразделения" value="${person.location}"/>
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
            <div class="col">
               Введите наименование подразделения
            </div>
        </div>
        <div class="row p-1 ">
            <div class="col">
                <label for="file" class="col-form-label">Фотография</label>
            </div>
            <div class="col">

                <input type="file" class="form-control" name="file" placeholder="Выберите фотографию" />
                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            </div>
            <div class="col">
                Выберите фотографию
            </div>
        </div>
        <input type="hidden" name="id" value="<#if person??>${person.id?c}</#if>"/>
        <button type="submit" class="btn btn-success m-2">Сохранить</button>
        <button class="btn btn-secondary m-2" onclick="history.back();return false;">Назад</button>
    </div>
</form>
