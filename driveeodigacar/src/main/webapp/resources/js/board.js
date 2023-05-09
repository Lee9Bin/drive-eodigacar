$(document).on('click', '#btnList', function() {
    const url = contextPath + '/board/getBoardList';
    location.href = url;
});

$(document).on('click', '#btnSave', function (e) {
    e.preventDefault(); 
    $('#form').submit(); 
});

$(document).on('click', '#btnUpdate', function() {
    const url = contextPath + '/board/editForm?id=' + boardId + '&mode=edit';
    location.href = url;
});

$(document).on('click', '#btnDelete', function() {
    const url = contextPath + '/board/deleteBoard?id=' + boardId;
    location.href = url;
});

$(document).on('click', '#btnWriteForm', function(e) {
    e.preventDefault();
    location.href = contextPath + '/board/boardForm';
});

function fn_contentView(id) {
    var url = contextPath + '/board/getBoardContent?id=' + id;
    location.href = url;
}

$(document).on('click', '#btnSearch', function(e) {
    e.preventDefault();
    var url = contextPath + '/board/getBoardList';
    url += '?searchType=' + $('#searchType').val();
    url += '&keyword=' + $('#keyword').val();
    location.href = url;
});

function fn_prev(page, range, rangeSize, searchType, keyword) {
    var page = (range - 2) * rangeSize + 1;
    var range = range - 1;
    var url = contextPath + '/board/getBoardList';
    url += '?page=' + page + '&range=' + range;
    url += '&searchType=' + searchType + '&keyword=' + keyword;
    location.href = url;
}

function fn_pagination(page, range, rangeSize, searchType, keyword) {
    var url = contextPath + '/board/getBoardList';
    url += '?page=' + page + '&range=' + range;
    url += '&searchType=' + searchType + '&keyword=' + keyword;
    location.href = url;
}

function fn_next(page, range, rangeSize, searchType, keyword) {
    var page = range * rangeSize + 1;
    var range = range + 1;
    var url = contextPath + '/board/getBoardList';
    url += '?page=' + page + '&range=' + range;
    url += '&searchType=' + searchType + '&keyword=' + keyword;
    location.href = url;
}
