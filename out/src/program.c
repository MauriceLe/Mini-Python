#include <stddef.h>

#include "assert.h"
#include "mpy_aliases.h"
#include "mpy_obj.h"
#include "builtins-setup.h"
#include "function-args.h"
#include "literals/tuple.h"
#include "literals/int.h"
#include "literals/boolean.h"
#include "literals/str.h"
#include "type-hierarchy/object.h"
#include "type-hierarchy/type.h"


__MPyObj *test;
__MPyObj* func_test(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("test", args, kwargs, 3);
	__MPyObj *x = __mpy_args_get_positional(&argHelper, 0, "x");
	__MPyObj *y = __mpy_args_get_positional(&argHelper, 1, "y");
	__MPyObj *z = __mpy_args_get_positional(&argHelper, 2, "z");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	retValue = __mpy_call(__mpy_obj_get_attr(__mpy_call(__mpy_obj_get_attr(x, "__mul__"), __mpy_tuple_assign(0, y, __mpy_obj_init_tuple(1)), NULL), "__add__"), __mpy_tuple_assign(0, z, __mpy_obj_init_tuple(1)), NULL);
	goto ret;
	
	__mpy_obj_ref_dec(x);
	__mpy_obj_ref_dec(y);
	__mpy_obj_ref_dec(z);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}

__MPyObj *cooleKlasse;
__MPyObj* func_cooleKlasse_methode(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("methode", args, kwargs, 3);
	__MPyObj *a = __mpy_args_get_positional(&argHelper, 0, "a");
	__MPyObj *b = __mpy_args_get_positional(&argHelper, 1, "b");
	__MPyObj *c = __mpy_args_get_positional(&argHelper, 2, "c");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	retValue = __mpy_call(__mpy_obj_get_attr(__mpy_call(__mpy_obj_get_attr(a, "__add__"), __mpy_tuple_assign(0, b, __mpy_obj_init_tuple(1)), NULL), "__add__"), __mpy_tuple_assign(0, c, __mpy_obj_init_tuple(1)), NULL);
	goto ret;
	
	__mpy_obj_ref_dec(a);
	__mpy_obj_ref_dec(b);
	__mpy_obj_ref_dec(c);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}

int main() {
	__mpy_builtins_setup();
	
	test = __mpy_obj_init_func(&func_test);
	__mpy_obj_ref_inc(test);
	
	cooleKlasse = __mpy_obj_init_type("cooleKlasse", __MPyType_Object);
	__mpy_obj_ref_inc(cooleKlasse);
	{
		__MPyObj *methode;
		methode = __mpy_obj_init_func(&func_cooleKlasse_methode);
		__mpy_obj_ref_inc(methode);
		__mpy_obj_set_attr(cooleKlasse, "methode", methode);
		__mpy_obj_ref_dec(methode);
	}
	
	
	
	__mpy_obj_ref_dec(test);
	
	__mpy_obj_ref_dec(cooleKlasse);
	
	__mpy_builtins_cleanup();
	return 0;
}
