.section .text
.global hochgeschwindigkeitsdivision
hochgeschwindigkeitsdivision:
    push %ebp
    mov %esp, %ebp
    mov 8(%ebp), %eax
    mov 12(%ebp), %ecx
    mov $0, %edx
    div %ecx
    mov %ebp, %esp
    pop %ebp
    ret