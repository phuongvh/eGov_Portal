$(document).ready(function($){
	$(".wd-calendar").datepicker({
		numberOfMonths: 1,
		changeMonth: true,
		dateFormat:"dd/mm/yy",
		yearRange:"-80:+80",
		monthNamesShort:["Th&#225;ng 1","Th&#225;ng 2","Th&#225;ng 3","Th&#225;ng 4","Th&#225;ng 5","Th&#225;ng 6","Th&#225;ng 7","Th&#225;ng 8","Th&#225;ng 9","Th&#225;ng 10"
		                 ,"Th&#225;ng 11","Th&#225;ng 12"],
		dayNamesMin:["CN","T2","T3","T4","T5","T6","T7"],
		changeYear: true
	});
    //external
    $('a[rel="external"]').attr('target', '_blank');
	$('#wd-slideshow img:first').fadeIn(1000, function() {
        $('#wd-slideshow').cycle();
    });
	//scroll
	if($('#mcs_container .customScrollBox .container .content').height() > 164){
		$("#mcs_container").mCustomScrollbar("vertical",300,"easeOutCirc",1.05,"auto","yes","yes",15); 
	}
	else{
		$('#mcs_container .dragger_container').css({'display':'none'});
	}
	
	$('h4.wd-open-sub').parent().find('ul.wd-list').slideDown();
	$('h4.wd-title-sub a').toggle(function(){
		$(this).parent().parent().parent().find('ul.wd-list').slideUp();
		$(this).parent().parent().find('ul.wd-list').slideDown();
		$(this).parent().parent().parent().find('h4').removeClass('wd-open-sub');
		$(this).parent().addClass('wd-open-sub');
	}, function(){
		$(this).parent().parent().find('ul.wd-list').slideUp();
		$(this).parent().removeClass('wd-open-sub');
		return this.click();
	});
	//form
	$('.wd-form-question input[type=radio]').prettyCheckboxes({'display':'inline'});
	//table
	$('.wd-table-three').find('tr:even').addClass('wd-even');
	//each element
	
	//popup signup
	$(".bt-votes-result").click(function (e)
	{
		ShowDialogSignup(false);
		e.preventDefault();
	});
	$(".wd-btnclose-sign").click(function (e)
	{
		HideDialogSignup();
		e.preventDefault();
	});
	
//function signup
function ShowDialogSignup(modal)
{
	$("#wd-overlay-sign").show();
	$("#wd-popup-sign").fadeIn(300);

	if (modal)
	{
		$("#wd-overlay-sign").unbind("click");
	}
	else
	{
		$("#wd-overlay-sign").click(function (e)
		{
			HideDialogSignup();
		});
	}
}
function HideDialogSignup()
{
	$("#wd-overlay-sign").hide();
	$("#wd-popup-sign").fadeOut(300);
}
	
if(!Modernizr.input.placeholder){
	$('[placeholder]').focus(function() {
		var input = $(this);
		if (input.val() == input.attr('placeholder')) {
		input.val('');
		input.removeClass('placeholder');
	}
	}).blur(function() {
		var input = $(this);
		if (input.val() == '' || input.val() == input.attr('placeholder')) {
		input.addClass('placeholder');
		input.val(input.attr('placeholder'));
	}
	}).blur();
		$('[placeholder]').parents('form').submit(function() {
		$(this).find('[placeholder]').each(function() {
		var input = $(this);
		if (input.val() == input.attr('placeholder')) {
			input.val('');
		}
		});
	});
  }

	$('.wd-boxs').removeClass('wd-boxs-first');
	
	$('#column-1').find('.wd-boxs:first').addClass('wd-boxs-first');
	$('#column-2').find('.wd-boxs:first').addClass('wd-boxs-first');
	$('#column-3').find('.wd-boxs:first').addClass('wd-boxs-first');
	
	$('#column-1').find('.wd-list-images a:first').addClass('wd-boxs-first');
	$('#column-2').find('.wd-list-images a:first').addClass('wd-boxs-first');
	$('#column-3').find('.wd-list-images a:first').addClass('wd-boxs-first');
	
	$('#column-1:not').find('.wd-boxs:first').removeClass('wd-boxs-first');
	$('#column-2:not').find('.wd-boxs:first').removeClass('wd-boxs-first');
	$('#column-3:not').find('.wd-boxs:first').removeClass('wd-boxs-first');
	
	$('#column-1:not').find('.wd-list-images a:first').removeClass('wd-boxs-first');
	$('#column-2:not').find('.wd-list-images a:first').removeClass('wd-boxs-first');
	$('#column-3:not').find('.wd-list-images a:first').removeClass('wd-boxs-first');
});
