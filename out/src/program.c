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




int main() {
	__mpy_builtins_setup();
	
	
	
	__mpy_obj_ref_dec(__mpy_call(test, __mpy_tuple_assign(0, __mpy_obj_init_int(1), __mpy_tuple_assign(1, __mpy_obj_init_int(2), __mpy_tuple_assign(2, __mpy_obj_init_int(3), __mpy_obj_init_tuple(3)))), NULL));
	__mpy_obj_ref_dec(__mpy_call(print, __mpy_tuple_assign(0, __mpy_call(test, __mpy_tuple_assign(0, __mpy_obj_init_int(1), __mpy_tuple_assign(1, __mpy_obj_init_int(2), __mpy_tuple_assign(2, __mpy_obj_init_int(3), __mpy_obj_init_tuple(3)))), NULL), __mpy_obj_init_tuple(1)), NULL));
	
	
	
	
	__mpy_builtins_cleanup();
	return 0;
}
