function getParameterByName(e) {
    e = e.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
    var t = new RegExp("[\\?&]" + e + "=([^&#]*)"), r = t.exec(location.search);
    return null === r ? "" : decodeURIComponent(r[1].replace(/\+/g, " "))
}
function createCookie(e, t, r) {
    if (r) {
        var a = new Date;
        a.setTime(a.getTime() + 24 * r * 60 * 60 * 1e3);
        var o = "; expires=" + a.toGMTString()
    } else var o = "";
    document.cookie = e + "=" + t + o + "; path=/"
}
function readCookie(e) {
    for (var t = e + "=", r = document.cookie.split(";"), a = 0; a < r.length; a++) {
        for (var o = r[a]; " " == o.charAt(0);)o = o.substring(1, o.length);
        if (0 == o.indexOf(t))return o.substring(t.length, o.length)
    }
    return"undefined"
}
if ($(".linkConversao").click(function () {
    "true" == $(this).attr("data-store-commission") && ga("send", "event", "Clique Conversão", $(this).attr("data-store-name"), "click-" + $(this).attr("data-link-type") + "-" + $(this).attr("data-coupon-type")), window.location.href = $(this).attr("data-url-redirect")
}), $(".js-toggle").click(function () {
    $(this).hasClass("truncate") ? $(this).removeClass("truncate") : $(this).addClass("truncate")
}), "undefined" === readCookie("source")) {
    if (getParameterByName("utm_source"))var source = getParameterByName("utm_source"), source = source + "-" + getParameterByName("utm_campaign"); else var source = document.referrer, source = source.match(/:\/\/(.[^/]+)/)[1], source = source.replace("http://", ""), source = source.replace("https://", ""), source = source.replace("/", ""), source = source.replace("www.", "");
    createCookie("source", source, 30)
}