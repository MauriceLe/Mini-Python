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

__MPyObj *dog;

__MPyObj *calculate;
__MPyObj* func_calculate(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("calculate", args, kwargs, 3);
	__MPyObj *a = __mpy_args_get_positional(&argHelper, 0, "a");
	__MPyObj *b = __mpy_args_get_positional(&argHelper, 1, "b");
	__MPyObj *c = __mpy_args_get_positional(&argHelper, 2, "c");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	retValue = __mpy_call(__mpy_obj_get_attr(a, "__add__"), __mpy_tuple_assign(0, __mpy_call(__mpy_obj_get_attr(b, "__mul__"), __mpy_tuple_assign(0, c, __mpy_obj_init_tuple(1)), NULL), __mpy_obj_init_tuple(1)), NULL);
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

__MPyObj *Dog;
__MPyObj* func_Dog___init__(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("__init__", args, kwargs, 1);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(__mpy_super, __mpy_tuple_assign(0, self, __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(self);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}
__MPyObj* func_Dog_wuff(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("wuff", args, kwargs, 1);
	__MPyObj *self = __mpy_args_get_positional(&argHelper, 0, "self");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("'Wuff!'"), __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(self);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}

int main() {
	__mpy_builtins_setup();
	dog = __mpy_obj_init_object();
	__mpy_obj_ref_inc(dog);
	
	calculate = __mpy_obj_init_func(&func_calculate);
	__mpy_obj_ref_inc(calculate);
	
	Dog = __mpy_obj_init_type("Dog", __MPyType_Object);
	__mpy_obj_ref_inc(Dog);
	{
		__MPyObj *__init__;
		__init__ = __mpy_obj_init_func(&func_Dog___init__);
		__mpy_obj_ref_inc(__init__);
		__mpy_obj_set_attr(Dog, "__init__", __init__);
		__mpy_obj_ref_dec(__init__);
	}
	{
		__MPyObj *wuff;
		wuff = __mpy_obj_init_func(&func_Dog_wuff);
		__mpy_obj_ref_inc(wuff);
		__mpy_obj_set_attr(Dog, "wuff", wuff);
		__mpy_obj_ref_dec(wuff);
	}
	
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("'ZeroDivisionError'"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("'NameError'"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("'ImportError'"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("'Error'"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("'Finally'"), __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(__mpy_call(Dog, __mpy_obj_init_tuple(0), NULL));
	__mpy_obj_ref_dec(dog);
	dog = __mpy_call(Dog, __mpy_obj_init_tuple(0), NULL);
	__mpy_obj_ref_inc(dog);
	__mpy_obj_ref_dec(__mpy_call(__mpy_obj_get_attr(dog, "wuff"), __mpy_obj_init_tuple(0), NULL));
	__mpy_obj_ref_dec(__mpy_call(function, __mpy_tuple_assign(0, __mpy_obj_init_int(1), __mpy_tuple_assign(1, __mpy_obj_init_int(2), __mpy_tuple_assign(2, __mpy_obj_init_int(3), __mpy_obj_init_tuple(3)))), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_call(function, __mpy_tuple_assign(0, __mpy_obj_init_int(1), __mpy_tuple_assign(1, __mpy_obj_init_int(2), __mpy_tuple_assign(2, __mpy_obj_init_int(3), __mpy_obj_init_tuple(3)))), NULL), __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(dog);
	
	__mpy_obj_ref_dec(calculate);
	
	__mpy_obj_ref_dec(Dog);
	
	__mpy_builtins_cleanup();
	return 0;
}
