/* Author: Antoine Neveux

*/

var scrolling = function(){
			    var speed     = 2000;
			    jQuery('a[href^="#"]').bind('click',function(){
			        var id = jQuery(this).attr('href');
			        if(id == '#')
			            goTo('body');
			        else
			            goTo(id);
			        return(false);
                 void(0);
			    });
			    function goTo(ancre){jQuery('html,body').animate({scrollTop:jQuery(ancre).offset().top},speed,'swing',function(){
			          if(ancre != 'body')
			                window.location.hash = ancre;
			          else
			              window.location.hash = '#';
			          jQuery(ancre).attr('tabindex','-1');
			          jQuery(ancre).focus();
			          jQuery(ancre).removeAttr('tabindex');
			      });
			    }
			};
			jQuery(function(){
				scrolling();
			});


