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


__MPyObj *fun;
__MPyObj* func_fun(__MPyObj *args, __MPyObj *kwargs) {
	assert(args != NULL && kwargs != NULL);
	
	__MPyGetArgsState argHelper = __mpy_args_init("fun", args, kwargs, 1);
	__MPyObj *a = __mpy_args_get_positional(&argHelper, 0, "a");
	__mpy_args_finish(&argHelper);
	
	__MPyObj *retValue = NULL;
	
	__MPyObj *b = __mpy_obj_init_object();
	__mpy_obj_ref_inc(b);
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, a, __mpy_obj_init_tuple(1)), NULL));
	__mpy_obj_ref_dec(b);
	b = __mpy_obj_init_int(1);
	__mpy_obj_ref_inc(b);
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, b, __mpy_obj_init_tuple(1)), NULL));
	
	__mpy_obj_ref_dec(a);
	
	goto ret;
	ret:
	if (retValue == NULL) {
		retValue = __mpy_obj_init_object();
	}
	return __mpy_obj_return(retValue);
}


int main() {
	__mpy_builtins_setup();
	
	fun = __mpy_obj_init_func(&func_fun);
	__mpy_obj_ref_inc(fun);
	
	
	__mpy_obj_ref_dec(__mpy_call(fun, __mpy_tuple_assign(0, __mpy_obj_init_int(10), __mpy_obj_init_tuple(1)), NULL));
	
	
	__mpy_obj_ref_dec(fun);
	
	
	__mpy_builtins_cleanup();
	return 0;
}
