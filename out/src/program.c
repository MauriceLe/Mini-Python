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

__MPyObj *var;

__MPyObj *function;
__MPyObj* func_function(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("function", args, kwargs, 2);
	__MPyObj *a = __mpy_args_get_positional(&argHelper, 0, "a");
	__MPyObj *b = __mpy_args_get_positional(&argHelper, 1, "b");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_call(__mpy_obj_get_attr(a, "__add__"), __mpy_tuple_assign(0, b, __mpy_obj_init_tuple(1)), NULL), __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(a);
	__mpy_obj_ref_dec(b);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}


int main() {
	__mpy_builtins_setup();
	var = __mpy_obj_init_object();
	__mpy_obj_ref_inc(var);
	
	function = __mpy_obj_init_func(&func_function);
	__mpy_obj_ref_inc(function);
	
	
	__mpy_obj_ref_dec(var);
	var = __mpy_obj_init_int(10);
	__mpy_obj_ref_inc(var);
	if (__mpy_boolean_raw(__mpy_call(__mpy_obj_get_attr(__mpy_call(__mpy_obj_get_attr(var, "__ge__"), __mpy_tuple_assign(0, __mpy_obj_init_int(1), __mpy_obj_init_tuple(1)), NULL), "__bool__"), __mpy_obj_init_tuple(0), NULL))) {
		__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("'Ja!'"), __mpy_obj_init_tuple(1)), NULL));
	}else {
		__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("'Nein!'"), __mpy_obj_init_tuple(1)), NULL));
	}while (__mpy_boolean_raw(__mpy_call(__mpy_obj_get_attr(__mpy_call(__mpy_obj_get_attr(var, "__le__"), __mpy_tuple_assign(0, __mpy_obj_init_int(15), __mpy_obj_init_tuple(1)), NULL), "__bool__"), __mpy_obj_init_tuple(0), NULL))) {
		__mpy_obj_ref_dec(var);
	var = __mpy_call(__mpy_obj_get_attr(var, "__add__"), __mpy_tuple_assign(0, __mpy_obj_init_int(1), __mpy_obj_init_tuple(1)), NULL);
	__mpy_obj_ref_inc(var);
		__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_obj_init_str_static("'Schleife'"), __mpy_obj_init_tuple(1)), NULL));
	}__mpy_obj_ref_dec(__mpy_call(function, __mpy_tuple_assign(0, __mpy_obj_init_int(10), __mpy_tuple_assign(1, __mpy_obj_init_int(20), __mpy_obj_init_tuple(2))), NULL));
	__mpy_obj_ref_dec(__mpy_call(function, __mpy_tuple_assign(0, __mpy_obj_init_str_static("'scuffed'"), __mpy_tuple_assign(1, __mpy_obj_init_str_static("'code'"), __mpy_obj_init_tuple(2))), NULL));
	
	__mpy_obj_ref_dec(var);
	
	__mpy_obj_ref_dec(function);
	
	
	__mpy_builtins_cleanup();
	return 0;
}
