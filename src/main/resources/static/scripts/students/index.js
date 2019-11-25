let indexModule = (function ($) {
  function main() {
    $("[data-toggle='tooltip']").tooltip();
  }

  return { main }
})(jQuery);

window.onload = indexModule.main;