.section .text
.global fibonacci
fibonacci:
	push %ebp
	mov %esp, %ebp
	mov 8(%ebp), %eax
	cmp $1, %eax
	jle out

	decl 8(%ebp)
	movl $0, 12(%ebp)
	movl $1, 16(%ebp)
	movl $0, %ecx

loop:
	incl %ecx
	mov 12(%ebp), %eax
	mov 16(%ebp), %edx
	add %edx, %eax
	mov %edx, 12(%ebp)
	mov %eax, 16(%ebp)
	mov 8(%ebp), %edx
	cmp %ecx, %edx
	jne loop
	jmp out

out:
	mov %ebp, %esp
	pop %ebp
	ret